package com.thesis.visageapp.service;

import com.thesis.visageapp.domain.OrderItem;
import com.thesis.visageapp.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAllItemsForAllOrders() throws SQLException;

    List<Product> getProductsForOrder(String orderId) throws IllegalAccessException;
}

