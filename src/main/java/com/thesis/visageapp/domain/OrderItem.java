package com.thesis.visageapp.domain;

public class OrderItem {
    private String orderItemId;

    private String productId;

    private Double itemGrossValue;

    private String orderId;

    public OrderItem(String orderItemId, String productId, Double itemGrossValue, String orderId) {
        this.orderItemId = orderItemId;
        this.productId = productId;
        this.itemGrossValue = itemGrossValue;
        this.orderId = orderId;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getItemGrossValue() {
        return itemGrossValue;
    }

    public void setItemGrossValue(Double itemGrossValue) {
        this.itemGrossValue = itemGrossValue;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
