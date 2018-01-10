package com.thesis.visageapp.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

public class Delivery {
    private String productId;
    private int quantity;

    public Delivery(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Delivery() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
