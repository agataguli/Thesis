package com.thesis.visageapp.service;

import com.thesis.visageapp.domain.Order;
import com.thesis.visageapp.domain.OrderItem;
import com.thesis.visageapp.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    void processOrder(String productId, int count) throws SQLException;

    String order(List<String> productsIds, String userId) throws IllegalAccessException, SQLException;

    List<Order> getHistoryOrders(String userId) throws SQLException;

    List<Order> getAllOrders() throws SQLException;

    Order getOrderWithId(String orderId) throws IllegalAccessException;

    void changeOrderStatus(String status, String orderId) throws SQLException;

    List<OrderItem> getOrderItemsItselfForOrder(String orderId);

    List<Product> getOrderItemsProductsProductForOrder(String orderId) throws IllegalAccessException;

    Object getAllOrdersWithStatus(String status);
}
