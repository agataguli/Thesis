package com.thesis.visageapp.domain.repository.impl;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.ProductFilter;
import com.thesis.visageapp.domain.User;
import com.thesis.visageapp.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> listOfProducts = new ArrayList<>();

    public InMemoryProductRepository() {
        this.takeAllProductsFromDatabase();
    }

    private void takeAllProductsFromDatabase() {
        MysqlConnector.connect();
        ResultSet rs = MysqlConnector.prepareStatement(StaticQueryParts.SELECT_ALL_QUERY + StaticQueryParts.PROD_TAB_NAME);
        Product product;

        try {
            while (rs.next()) {
                product = createProductByResponse(rs);
                this.listOfProducts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MysqlConnector.disconnect();
    }

    private Product createProductByResponse(ResultSet rs) throws SQLException {
        Product product = new Product(
                rs.getString(StaticQueryParts.PROD_PRODUCT_ID), rs.getString(StaticQueryParts.PROD_NAME),
                rs.getString(StaticQueryParts.PROD_CATEGORY), rs.getString(StaticQueryParts.PROD_BRAND),
                rs.getDouble(StaticQueryParts.PROD_GROSS_VALUE), rs.getDouble(StaticQueryParts.PROD_NET_VALUE),
                rs.getString(StaticQueryParts.PROD_DESCRIPTION), rs.getInt(StaticQueryParts.PROD_QUANTITY),
                rs.getString(StaticQueryParts.PROD_IMAGE_LINK), rs.getBoolean(StaticQueryParts.PROD_AVAILABLE)
        );
        return product;
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
    public void addProduct(Product product) throws SQLException {
        listOfProducts.add(product);
        String addQuery = StaticQueryParts.insertQuery(StaticQueryParts.PROD_TAB_NAME, product.getAttributesValues());
        MysqlConnector.executeOnDatabase(addQuery);
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
        // TODO: implement it! in cart area.
        try {
            Product product = this.getProductWithId(productId);
            product.orderIfAvailable();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    @Override
    public void changeAvailability(boolean available, String productId) throws SQLException {
        String updateQuery = StaticQueryParts.updateQuery(StaticQueryParts.PROD_TAB_NAME, StaticQueryParts.PROD_AVAILABLE,
                String.valueOf(available), StaticQueryParts.buildCondition(StaticQueryParts.PROD_PRODUCT_ID, productId));
        MysqlConnector.executeOnDatabase(updateQuery);
    }

    @Override
    public void changeQuantity(int quantity, String productId) throws SQLException {
        String updateQuery = StaticQueryParts.updateQuery(StaticQueryParts.PROD_TAB_NAME, StaticQueryParts.PROD_QUANTITY,
                String.valueOf(quantity), StaticQueryParts.buildCondition(StaticQueryParts.PROD_PRODUCT_ID, productId));
        MysqlConnector.executeOnDatabase(updateQuery);
    }

    @Override
    public List getFilteredProducts(ProductFilter requestBody) {
        List<Product> listOfFilteredProducts = new ArrayList<>();
        for(Product product: this.listOfProducts) {
            if(requestBody.getProductName().equalsIgnoreCase(product.getName()) || requestBody.getProductName().isEmpty()){
                if(requestBody.getProductBrand().equalsIgnoreCase(product.getBrand()) || requestBody.getProductBrand().isEmpty()){
                    if(requestBody.getProductPriceMax() <= product.getGrossValue() || requestBody.getProductPriceMax().isNaN()) {
                        if(requestBody.getProductPriceMin() >= product.getGrossValue() || requestBody.getProductPriceMin().isNaN()) {
                            if(requestBody.isProductCategoryAccessories() && product.getCategory().equalsIgnoreCase(StaticQueryParts.PROD_CATEGORY_ACCESSORIES)) {
                                listOfFilteredProducts.add(product);
                            } else {
                                if(requestBody.isProductCategoryBrushes() && product.getCategory().equalsIgnoreCase(StaticQueryParts.PROD_CATEGORY_BRUSHES)) {
                                    listOfFilteredProducts.add(product);
                                } else {
                                    if(requestBody.isProductCategoryFurniture() && product.getCategory().equalsIgnoreCase(StaticQueryParts.PROD_CATEGORY_FURNITURE)) {
                                        listOfFilteredProducts.add(product);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return listOfFilteredProducts;
    }
}
