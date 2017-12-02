package com.thesis.visageapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.repository.ProductRepository;
import com.thesis.visageapp.service.OrderService;

import java.sql.SQLException;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int count) throws SQLException {

        try {
            Product productById = productRepository.getProductWithId(productId);
            if (productById.getQuantity() < count) {
                throw new IllegalArgumentException("Quantity of product: " + productId + "is out off stock, current quantity:" + productById.getQuantity());
            }
            productById.setQuantity(productById.getQuantity() - count);
            productRepository.changeQuantity(productById.getQuantity(), productById.getProductId());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
