package com.thesis.visageapp.domain;

/**
 * Created by Agatka on 15.10.2017.
 */
public class DeliveredItem {
    private String deliveredItemId;
    private String productId;
    private int quantity;

    //TODO make this file just writing delivery file and updating product quantity etc

    public DeliveredItem(String deliveredItemId, String productId, int quantity) {
        this.deliveredItemId = deliveredItemId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
        DeliveredItem other = (DeliveredItem) object;
        if (deliveredItemId == null) {
            if (other.deliveredItemId != null) {
                return false;
            }
        } else if (!deliveredItemId.equals(other.deliveredItemId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((deliveredItemId == null) ? 0 : deliveredItemId.hashCode());
        return result;
    }

    public String getDeliveredItemId() {
        return deliveredItemId;
    }

    public void setDeliveredItemId(String deliveredItemId) {
        this.deliveredItemId = deliveredItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
