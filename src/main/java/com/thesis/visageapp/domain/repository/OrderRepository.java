package com.thesis.visageapp.domain.repository;

import com.thesis.visageapp.domain.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository {
    List getAllOrders();

    String createOrder(String userId, Double totalGrossValue) throws SQLException;

    List getHistoryOrders(String userId) throws SQLException;

    Order getOrderWithId(String orderId) throws IllegalAccessException;

    void changeOrderStatus(String status, String orderId) throws SQLException;

    List<Order> getAllOrdersWithStatus(String status);
}
