package com.thesis.visageapp.domain;

public class ProductFilter {
    private String productName;
    private String productBrand;
    private Double productPriceMin;
    private Double productPriceMax;
    private boolean productCategoryFurniture;
    private boolean productCategoryBrushes;
    private boolean productCategoryAccessories;

    public ProductFilter() {
    }

    public ProductFilter(String productName, String productBrand, Double productPriceMin, Double productPriceMax,
                         boolean productCategoryFurniture, boolean productCategoryBrushes, boolean productCategoryAccessories) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPriceMin = productPriceMin;
        this.productPriceMax = productPriceMax;
        this.productCategoryFurniture = productCategoryFurniture;
        this.productCategoryBrushes = productCategoryBrushes;
        this.productCategoryAccessories = productCategoryAccessories;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public Double getProductPriceMin() {
        return productPriceMin;
    }

    public Double getProductPriceMax() {
        return productPriceMax;
    }

    public boolean isProductCategoryFurniture() {
        return productCategoryFurniture;
    }

    public boolean isProductCategoryBrushes() {
        return productCategoryBrushes;
    }

    public boolean isProductCategoryAccessories() {
        return productCategoryAccessories;
    }
}
