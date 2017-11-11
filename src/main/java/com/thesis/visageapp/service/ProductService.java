package com.thesis.visageapp.service;

import com.thesis.visageapp.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Agatka
 */
public interface ProductService {
    List<Product> getAllProducts();

    Product getProductWithId(String productId) throws IllegalAccessException;

    List <Product> getProductsWithCategory(String category);

    Set<Product> getProductsWithFilter(Map<String, List<String>> filterParams);

    void addProduct(Product product);

    List<Product> getProductsWithAvailableStatus(boolean isAvailable);

    void orderProduct(String productId);

    void changeAvailability(String productId);

    void updateQuantityByDelivered(String productId, Integer quantity);
}
