package com.thesis.visageapp.domain.repository;

import com.thesis.visageapp.domain.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderItemRepository {

    String createOrderItem(String productId, Double value, String orderId) throws SQLException;

    List<OrderItem> getAllItemsForAllOrders();

    List<OrderItem> getProductsForOrder(String orderId);
}
