package com.thesis.visageapp.service.impl;

import com.thesis.visageapp.domain.OrderItem;
import com.thesis.visageapp.domain.repository.OrderItemRepository;
import com.thesis.visageapp.domain.repository.OrderRepository;
import com.thesis.visageapp.domain.repository.ProductRepository;
import com.thesis.visageapp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public List<OrderItem> getAllItemsForAllOrders() throws SQLException {
        return this.orderItemRepository.getAllItemsForAllOrders();
    }

    @Override
    public List<OrderItem> getProductsForOrder(String orderId) {
        return this.orderItemRepository.getItemsForOrder(orderId);
    }
}
