package com.thesis.visageapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.repository.ProductRepository;
import com.thesis.visageapp.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void processOrder(String productId, int count) {

        try {
            Product productById = productRepository.getProductWithId(productId);
            if (productById.getQuantity() < count) {
                throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba sztuk w magazynie : " + productById.getQuantity());
            }
            productById.setQuantity(productById.getQuantity() - count);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
