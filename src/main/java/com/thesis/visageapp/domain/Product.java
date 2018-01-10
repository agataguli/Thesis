package com.thesis.visageapp.domain;

import com.sun.media.jfxmedia.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productId;
    private String name;
    private String category;
    private String brand;
    private Double grossValue;
    private Double netValue;
    private String description;
    private int quantity;
    private String imageLink;
    private boolean available = true;

    public Product() {
        super();
    }

    public Product(String productId, String name, String category, String brand, Double grossValue,
                   Double netValue, String description, int quantity, String imageLink, boolean available) {
        this(productId, name, category, brand, grossValue, netValue, description, quantity);
        this.imageLink = imageLink;
        this.available = available;
    }

    public Product(String productId, String name, String category, String brand, Double grossValue, Double netValue,
                   String description, int quantity) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.grossValue = grossValue;
        this.netValue = netValue;
        this.description = description;
        this.quantity = quantity;
        this.imageLink = null;
        this.available = true;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Product other = (Product) object;
        if (productId == null) {
            if (other.productId != null) {
                return false;
            }
        } else if (!productId.equals(other.productId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", brand=" + brand + "]";
    }

    public String getProductId() {
        return productId;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public Double getGrossValue() {
        return grossValue;
    }

    public Double getNetValue() {
        return netValue;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void orderIfAvailable() {
        if (!available || quantity == 0) {
            Logger.logMsg(0, "Cannot order, product unattainable");
            return;
        }
        this.quantity--;
    }

    public boolean isAvailable(int orderedItemsQuantity) {
        return this.available && this.quantity >= orderedItemsQuantity;
    }

    public void changeAvailability() {
        this.available = !this.available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateQuantityByDelivered(Integer quantity) {
        this.quantity += quantity;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setGrossValue(Double grossValue) {
        this.grossValue = grossValue;
    }

    public void setNetValue(Double netValue) {
        this.netValue = netValue;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List getAttributesValues() {
        List values = new ArrayList();
        values.add(productId); values.add(name); values.add(category); values.add(brand); values.add(grossValue);
        values.add(netValue); values.add(description); values.add(quantity); values.add(imageLink); values.add(available);
        return values;
    }
}
