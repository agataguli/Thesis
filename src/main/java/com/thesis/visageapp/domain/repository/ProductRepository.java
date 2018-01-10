package com.thesis.visageapp.domain.repository;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.ProductFilter;

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

    List getFilteredProducts(ProductFilter requestBody) throws SQLException;

    List getUserFavProducts(String userId) throws SQLException;

    String addProductToUserFavProductList(String userId, String productId) throws SQLException;

    String removeProductToUserFavProductList(String userId, String productId) throws SQLException;

    String checkAreProductsAvailable(Map<String, Integer> groupedByQuantityAndIds);

    List<Product> getProductsWithIds(List<String> productsIds) throws IllegalAccessException;

    void updateProductQuantity(int quantity, String productId) throws IllegalAccessException, SQLException;
}
