package com.thesis.visageapp.domain.repository;

import com.thesis.visageapp.domain.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {

   List<Product> getAllProducts();

   Product getProductWithId(String productId) throws IllegalAccessException;

   List <Product> getProductsWithCategory(String category);

   Set<Product> getProductsWithFilter(Map<String,List<String>> filterParams);

   void addProduct(Product product) throws SQLException;

   List<Product> getProductsWithAvailableStatus(boolean isAvailable);

   void orderProduct(String productId);

    void changeAvailability(boolean available, String productId) throws SQLException;

    void changeQuantity(int quantity, String productId) throws SQLException;
}
