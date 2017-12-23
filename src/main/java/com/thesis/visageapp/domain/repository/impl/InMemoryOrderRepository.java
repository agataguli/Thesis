package com.thesis.visageapp.domain.repository.impl;

import com.thesis.visageapp.domain.Order;
import com.thesis.visageapp.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    List<Order> listOfOrders = new ArrayList<>();

    public InMemoryOrderRepository() {
        this.takeAllOrdersFromDatabase();
    }

    private Order createOrderByResponse(ResultSet rs) throws SQLException {
        Order order = new Order(rs.getString(StaticQueryParts.ORDER_ORDER_ID), rs.getString(StaticQueryParts.ORDER_USER_ID),
                rs.getDouble(StaticQueryParts.ORDER_GROSS_VALUE), rs.getString(StaticQueryParts.ORDER_STATUS),
                rs.getInt(StaticQueryParts.ORDER_DATE));
        return order;
    }

    private void takeAllOrdersFromDatabase() {
        MysqlConnector.connect();
        ResultSet rs = MysqlConnector.prepareStatement(StaticQueryParts.SELECT_ALL_QUERY
                + StaticQueryParts.ORDER_TAB_NAME);
        Order order;

        try {
            while (rs.next()) {
                order = createOrderByResponse(rs);
                this.listOfOrders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MysqlConnector.disconnect();
    }

    private void updateListItemStatus(String orderId, String status) {
        for(Order order : this.listOfOrders) {
            if(order.getOrderId().equals(orderId)) {
                order.setStatus(status);
                return;
            }
        }
    }

    @Override
    public List getAllOrders() {
        return this.listOfOrders;
    }

    @Override
    public String createOrder(String userId, Double totalGrossValue) throws SQLException {
        MysqlConnector.connect();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String orderId = String.valueOf(UUID.randomUUID());
        List<String> supplierNames = Arrays.asList(orderId, userId, String.valueOf(totalGrossValue),
                StaticQueryParts.ORDER_STATUS_ACTIVE, format.format(cal.getTime()));

        String addQuery = StaticQueryParts.insertQuery(StaticQueryParts.ORDER_TAB_NAME, (supplierNames));
        MysqlConnector.executeOnDatabase(addQuery);
        return orderId;

    }

    @Override
    public List<Order> getHistoryOrders(String userId) throws SQLException {
        MysqlConnector.connect();
        ResultSet rs = MysqlConnector.prepareStatement(StaticQueryParts.getUserHistoryOrders(userId));
        List<Order> listOfOrders = new ArrayList<>();
        Order order;

        try {
            while (rs.next()) {
                order = createOrderByResponse(rs);
                listOfOrders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MysqlConnector.disconnect();
        return listOfOrders;
    }

    @Override
    public Order getOrderWithId(String orderId) throws IllegalAccessException {
        Order orderById = null;
        for (Order order : this.listOfOrders) {
            if (order != null && order.getOrderId() != null && order.getOrderId().equals(orderId)) {
                orderById = order;
                break;
            }
        }
        if (orderById == null) {
            throw new IllegalAccessException("No order with id:" + orderId);
        }
        return orderById;
    }

    @Override
    public void changeOrderStatus(String status, String orderId) throws SQLException {
        if (status.equalsIgnoreCase(StaticQueryParts.ORDER_STATUS_ACTIVE) || status.equalsIgnoreCase
                (StaticQueryParts.ORDER_STATUS_CANCELLED) || status.equalsIgnoreCase(StaticQueryParts.ORDER_STATUS_DONE)) {
            String updateQuery = StaticQueryParts.updateQuery(StaticQueryParts.ORDER_TAB_NAME, StaticQueryParts.ORDER_STATUS,
                    status, StaticQueryParts.buildCondition(StaticQueryParts.ORDER_ORDER_ID, orderId));
            MysqlConnector.executeOnDatabase(updateQuery);
            updateListItemStatus(orderId, status);
        } else {
            new IllegalArgumentException("Cannot change order: " + orderId + ", to status: " + status);
        }
    }
}
