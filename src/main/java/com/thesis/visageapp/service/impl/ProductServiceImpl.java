package com.thesis.visageapp.service.impl;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.repository.ProductRepository;
import com.thesis.visageapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Agatka
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductWithId(String productId) throws IllegalAccessException {
        return productRepository.getProductWithId(productId);
    }

    @Override
    public List<Product> getProductsWithCategory(String category) {
        return productRepository.getProductsWithCategory(category);
    }

    @Override
    public Set<Product> getProductsWithFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsWithFilter(filterParams);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public List<Product> getProductsWithAvailableStatus(boolean isAvailable) {
        return productRepository.getProductsWithAvailableStatus(isAvailable);
    }

    @Override
    public void orderProduct(String productId) {
        // TODO: implement this ordering product method
    }

    @Override
    public void changeAvailability(String productId) {
        try {
            Product productById = productRepository.getProductWithId(productId);
            productById.changeAvailability();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Cannot change Availability");
        }
    }

    @Override
    public void updateQuantityByDelivered(String productId, Integer quantity) {
        try {
            Product productById = productRepository.getProductWithId(productId);
            productById.updateQuantityByDelivered(quantity);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Cannot change quantity");
        }
    }
}
