package com.thesis.visageapp.service.impl;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.ProductFilter;
import com.thesis.visageapp.domain.repository.ProductRepository;
import com.thesis.visageapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.getAllProducts();
    }

    @Override
    public Product getProductWithId(String productId) throws IllegalAccessException {
        return this.productRepository.getProductWithId(productId);
    }

    @Override
    public List<Product> getProductsWithCategory(String category) {
        return this.productRepository.getProductsWithCategory(category);
    }

    @Override
    public Set<Product> getProductsWithFilter(Map<String, List<String>> filterParams) {
        return this.productRepository.getProductsWithFilter(filterParams);
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        this.productRepository.addProduct(product);
    }

    @Override
    public List<Product> getProductsWithAvailableStatus(boolean isAvailable) {
        return this.productRepository.getProductsWithAvailableStatus(isAvailable);
    }

    @Override
    public void orderProduct(String productId) {
        // TODO: implement this ordering product method
    }

    @Override
    public void changeAvailability(String productId) throws SQLException {
        try {
            Product productById = this.productRepository.getProductWithId(productId);
            productById.changeAvailability();
            this.productRepository.changeAvailability(productById.isAvailable(), productById.getProductId());
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Cannot change Availability");
        }
    }

    @Override
    public void updateQuantityByDelivered(String productId, Integer quantity) {
        try {
            Product productById = this.productRepository.getProductWithId(productId);
            productById.updateQuantityByDelivered(quantity);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Cannot change quantity");
        }
    }

    @Override
    public List getFilteredProducts(ProductFilter requestBody) {
        return this.productRepository.getFilteredProducts(requestBody);
    }
}
