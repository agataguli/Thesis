package com.thesis.visageapp.service;

import com.thesis.visageapp.domain.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAllItemsForAllOrders() throws SQLException;

    List<OrderItem> getProductsForOrder(String orderId);
}

