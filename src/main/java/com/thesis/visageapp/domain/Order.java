package com.thesis.visageapp.domain;

public class Order {
    private String orderId;

    private String userId;

    private Double orderGrossValue;

    private String status;

    private int date;


    public Order(String orderId, String userId, Double orderGrossValue, String status, int date) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderGrossValue = orderGrossValue;
        this.status = status;
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getOrderGrossValue() {
        return orderGrossValue;
    }

    public void setOrderGrossValue(Double orderGrossValue) {
        this.orderGrossValue = orderGrossValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
