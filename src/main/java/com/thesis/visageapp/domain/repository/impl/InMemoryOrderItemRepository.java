package com.thesis.visageapp.domain.repository.impl;

import com.thesis.visageapp.domain.OrderItem;
import com.thesis.visageapp.domain.repository.OrderItemRepository;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class InMemoryOrderItemRepository implements OrderItemRepository {

    List <OrderItem> listOfOrderItems = new ArrayList<>();

    public InMemoryOrderItemRepository() {
        this.takeAllOrderItemsFromDatabase();
    }

    private OrderItem createOrderItemByResponse(ResultSet rs) throws SQLException {
        OrderItem orderItem = new OrderItem(rs.getString(StaticQueryParts.ORDERITEM_ORDERITEM_ID), rs.getString(StaticQueryParts.ORDERITEM_PRODUCT_ID),
                rs.getDouble(StaticQueryParts.ORDERITEM_GROSS_VALUE), rs.getString(StaticQueryParts.ORDERITEM_ORDER_ID));
        return orderItem;
    }

    private void takeAllOrderItemsFromDatabase() {
        MysqlConnector.connect();
        ResultSet rs = MysqlConnector.prepareStatement(StaticQueryParts.SELECT_ALL_QUERY
                + StaticQueryParts.ORDERITEM_TAB_NAME);
        OrderItem orderItem;

        try {
            while (rs.next()) {
                orderItem = createOrderItemByResponse(rs);
                this.listOfOrderItems.add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MysqlConnector.disconnect();
    }

    @Override
    public List getAllOrderItem() {
        return this.listOfOrderItems;
    }

    @Override
    public String createOrderItem(String productId, Double itemGrossValue, String orderId) throws SQLException {
        MysqlConnector.connect();
        String orderItemId = String.valueOf(UUID.randomUUID());
        List<String> supplierNames = Arrays.asList(orderItemId, productId,
                String.valueOf(itemGrossValue), orderId);

        String addQuery = StaticQueryParts.insertQuery(StaticQueryParts.ORDERITEM_TAB_NAME,(supplierNames));
        MysqlConnector.executeOnDatabase(addQuery);
        return orderItemId;

}

}
