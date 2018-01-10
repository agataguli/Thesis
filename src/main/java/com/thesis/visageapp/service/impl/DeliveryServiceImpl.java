package com.thesis.visageapp.service.impl;

import com.thesis.visageapp.domain.Delivery;
import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.repository.ProductRepository;
import com.thesis.visageapp.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addDelivery(Delivery deliveryToBeAdded) throws SQLException, IllegalAccessException {
        this.executeDelivery(deliveryToBeAdded);
    }

    private void executeDelivery(Delivery deliveryToBeAdded) throws SQLException, IllegalAccessException {
        if(deliveryToBeAdded.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be gt than 0");
        } else {
            this.productRepository.updateProductQuantity(deliveryToBeAdded.getQuantity(), deliveryToBeAdded.getProductId());
            Product productById = this.productRepository.getProductWithId(deliveryToBeAdded.getProductId());
            productById.setQuantity(deliveryToBeAdded.getQuantity() + productById.getQuantity());
        }
    }
}


