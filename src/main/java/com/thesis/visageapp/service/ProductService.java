package com.thesis.visageapp.service;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.ProductFilter;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductWithId(String productId) throws IllegalAccessException;

    List <Product> getProductsWithCategory(String category);

    Set<Product> getProductsWithFilter(Map<String, List<String>> filterParams);

    void addProduct(Product product) throws SQLException;

    List<Product> getProductsWithAvailableStatus(boolean isAvailable);

    void orderProduct(String productId);

    void changeAvailability(String productId) throws SQLException;

    void updateQuantityByDelivered(String productId, Integer quantity);

    List getFilteredProducts(ProductFilter requestBody);

    List getUserFavProducts(String userId) throws SQLException;;
}
