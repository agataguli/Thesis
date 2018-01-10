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
        ResultSet rs = MysqlConnector.prepareStatement(StaticQueryParts.SELECT_ALL_QUERY
                + StaticQueryParts.PROD_TAB_NAME);
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
        String avai = "0";
        if(available) avai = "1";
        String updateQuery = StaticQueryParts.updateQuery(StaticQueryParts.PROD_TAB_NAME, StaticQueryParts.PROD_AVAILABLE,
                avai, StaticQueryParts.buildCondition(StaticQueryParts.PROD_PRODUCT_ID, productId));
        MysqlConnector.executeOnDatabase(updateQuery);
    }

    private void updateProductData(String productId, int quantity, String brand) {
        for(Product product : this.listOfProducts) {
            if(product.getProductId().equals(productId)) {
                if(quantity>0){product.setQuantity(quantity);}
                else{product.setBrand(brand);}
                return;
            }
        }
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
                    if(requestBody.getProductPriceMax() >= product.getGrossValue() || requestBody.getProductPriceMax()==100000) {
                        if(requestBody.getProductPriceMin() <= product.getGrossValue() || requestBody.getProductPriceMin()==0) {
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

    @Override
    public List getUserFavProducts(String userId) {
        MysqlConnector.connect();
        ResultSet rs = MysqlConnector.prepareStatement(StaticQueryParts.getIdsOfFavoriteUserProducts(userId));
        List<String> listOfProductIds = new ArrayList<>();
        Product p = null;

        try {
            while (rs.next()) {
                listOfProductIds.add(rs.getString(StaticQueryParts.PROD_PRODUCT_ID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MysqlConnector.disconnect();

        List<Product> listOfFilteredProducts = new ArrayList<>();
        for(String s: listOfProductIds) {
            try {
                p = this.getProductWithId(s);
                if(p != null) {
                    listOfFilteredProducts.add(p);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return listOfFilteredProducts;
    }

    @Override
    public String addProductToUserFavProductList(String userId, String productId) throws SQLException {
        List<String> values = new ArrayList<>();
        values.add(UUID.randomUUID().toString());
        values.add(String.valueOf(userId));
        values.add(String.valueOf(productId));
        String addQuery = StaticQueryParts.insertQuery(StaticQueryParts.FAV_TAB_NAME, values);
        MysqlConnector.executeOnDatabase(addQuery);
        return StaticQueryParts.RESPONSE_CODE_SUCCESS;
    }

    @Override
    public String removeProductToUserFavProductList(String userId, String productId) throws SQLException {
        String removeQuery = StaticQueryParts.removeFromFavList(userId, productId);
        MysqlConnector.executeOnDatabase(removeQuery);
        return StaticQueryParts.RESPONSE_CODE_SUCCESS;
    }

    @Override
    public String checkAreProductsAvailable(Map<String, Integer> groupedByQuantityAndIds) {
        final String[] value = {StaticQueryParts.RESPONSE_CODE_SUCCESS};
        groupedByQuantityAndIds.forEach((k,v) -> {
            try {
                if(!this.getProductWithId(k).isAvailable(v)) {
                    value[0] = StaticQueryParts.RESPONSE_CODE_ERROR_ORDER_NOT_ENOUGH_PRODUCTS + k + this.getProductWithId(k).getQuantity();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return value[0];
    }

    @Override
    public List<Product> getProductsWithIds(List<String> productsIds) throws IllegalAccessException {
        List <Product> products = new ArrayList<>();
        Product fromRepo;
        for(String pr : productsIds) {
            fromRepo = this.getProductWithId(pr);
            if(fromRepo != null) {
                products.add(fromRepo);
            }
        }
        return products;
    }

    @Override
    public void updateProductQuantity(int quantity, String productId) throws IllegalAccessException, SQLException {
        Product product = this.getProductWithId(productId);
        product.setQuantity(quantity + product.getQuantity());
        this.changeQuantity(product.getQuantity(), productId);
        this.updateProductData(productId, product.getQuantity(), null);
    }
}
