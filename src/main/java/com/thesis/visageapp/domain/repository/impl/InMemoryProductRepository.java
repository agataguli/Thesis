package com.thesis.visageapp.domain.repository.impl;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Agatka
 */
@Repository
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> listOfProducts = new ArrayList<>();

    // TODO: replace this fake repository with some JDBC solution, best Hibernate.
    public InMemoryProductRepository() {
        Product product1 = new Product("1", "MBrush Foundation brush","Brush", "MBrush", new BigDecimal(89.75), new BigDecimal(70), "Foundation brush created by Maxineczka", 7, false);
        Product product2 = new Product("2", "Brush", "NikkieTutorials fish contour brush","Nikkie", new BigDecimal(129.99), new BigDecimal(100), "Cream contour brush created by Nikkie Tutorials", 30);
        listOfProducts.add(product1);
        listOfProducts.add(product2);
    }


    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public Product getProductWithId(String productId) throws IllegalAccessException {
        Product productById = null;
        for (Product product : listOfProducts) {
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
                productById = product;
                break;
            }
        }
        if (productById == null) {
            // TODO: move all messsages and strings to property file!
            throw new IllegalAccessException("No product with id:" + productId);
        }
        return productById;
    }

    @Override
    public List<Product> getProductsWithCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : listOfProducts) {
            if (category.equalsIgnoreCase(product.getCategory())) productsByCategory.add(product);
        }
        return productsByCategory;
    }

    @Override
    public Set<Product> getProductsWithFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        Set<String> criterias = filterParams.keySet();
        if (criterias.contains("brand")) {
            for (String brandName : filterParams.get("brand")) {
                for (Product product : listOfProducts) {
                    if (brandName.equalsIgnoreCase(product.getBrand())) {
                        productsByBrand.add(product);
                    }
                }
            }
        }
        if (criterias.contains("category")) {
            for (String category : filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsWithCategory(category));
            }
        }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
    }

    @Override
    public void addProduct(Product product) {
        listOfProducts.add(product);
    }


    @Override
    public List<Product> getProductsWithAvailableStatus(boolean isAvailable) {
        List<Product> productList = new ArrayList<>();
        for (Product product : listOfProducts) {
            if (product.isAvailable() == isAvailable) productList.add(product);
        }
        return productList;
    }

    @Override
    public void orderProduct(String productId) {
        try {
            Product product = this.getProductWithId(productId);
            product.orderIfAvailable();
        } catch (IllegalAccessException e) {
            // TODO: replace blocks like this with code not blocking all server :D
            throw new IllegalArgumentException(e.getMessage());
        }

    }
}
