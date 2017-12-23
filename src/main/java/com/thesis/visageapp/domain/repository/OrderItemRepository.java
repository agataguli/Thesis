package com.thesis.visageapp.domain.repository;

import com.thesis.visageapp.domain.OrderItem;
import com.thesis.visageapp.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface OrderItemRepository {

    String createOrderItem(String productId, Double value, String orderId) throws SQLException;

    List<OrderItem> getAllItemsForAllOrders();

    List<OrderItem> getItemsForOrder(String orderId);

    List<String> getOrderedProductsIdsInOrder(String orderId);
}
