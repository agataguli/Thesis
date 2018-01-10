package com.thesis.visageapp.service.impl;

import com.thesis.visageapp.domain.OrderItem;
import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.repository.OrderItemRepository;
import com.thesis.visageapp.domain.repository.OrderRepository;
import com.thesis.visageapp.domain.repository.ProductRepository;
import com.thesis.visageapp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
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
    public List<Product> getProductsForOrder(String orderId) throws IllegalAccessException {
        List<Product> orderedProducts = new ArrayList<>();
        List<OrderItem> orderedItems = this.orderItemRepository.getItemsForOrder(orderId);
        for(OrderItem orderItem: orderedItems) {
            orderedProducts.add(this.productRepository.getProductWithId(orderItem.getProductId()));
        }
        return orderedProducts;
    }
}
