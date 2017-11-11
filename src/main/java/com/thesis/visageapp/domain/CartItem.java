package com.thesis.visageapp.domain;

import java.math.BigDecimal;

/**
 * Created by Agatka on 24.10.2017.
 */
public class CartItem {
    private BigDecimal totalMultipliedItemGrossValue;
    private Product product;
    private int quantity;

    public CartItem() {
        // empty constructor
    }

    public CartItem(Product product) {
        super();
        this.totalMultipliedItemGrossValue = product.getGrossValue();
        this.product = product;
        this.quantity = 1;
    }

    public BigDecimal getTotalMultipliedItemGrossValue() {
        return totalMultipliedItemGrossValue;
    }

    public void setTotalMultipliedItemGrossValue(BigDecimal totalMultipliedItemGrossValue) {
        this.totalMultipliedItemGrossValue = totalMultipliedItemGrossValue;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        if (product == null) {
            if (cartItem.product != null) return false;
        } else if (!product.equals(cartItem.product)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 311;
        int result = 1;
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        return result;
    }
}
