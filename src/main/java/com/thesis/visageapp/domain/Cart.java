package com.thesis.visageapp.domain;

import java.util.*;

public class Cart {
    private String cartId;
    private Double totalCartItemsGrossValue;
    private String userId;
    private List <String> cartItems;


    public void setCartItems(List<String> cartItems) {
        this.cartItems = cartItems;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Cart() {
        cartItems = new ArrayList<String>();
        totalCartItemsGrossValue = Double.valueOf(0);
    }

    public Cart(String cartId) {
        this.cartId = cartId;
    }

    public void addCartItem(Product cartItemToAdd) {
        String itemProductId = cartItemToAdd.getProductId();
       // cartItems.add(cartItemToAdd);
        this.updateTotalCartItemsGrossValue();
    }

    public void removeCartItem(Product cartItemToRemove) {
        cartItems.remove(cartItemToRemove.getProductId());
        this.updateTotalCartItemsGrossValue();
    }

    private void updateTotalCartItemsGrossValue() {
        this.totalCartItemsGrossValue = Double.valueOf(0);
       // for (Product cartItem : cartItems) {
       //     this.totalCartItemsGrossValue += cartItem.getGrossValue();
       // }
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Double getTotalCartItemsGrossValue() {
        return totalCartItemsGrossValue;
    }

    public void setTotalCartItemsGrossValue(Double totalCartItemsGrossValue) {
        this.totalCartItemsGrossValue = totalCartItemsGrossValue;
    }

    public List<String> getCartItems() {
        return cartItems;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;
        if (this.cartId == null) {
            if (cart.cartId != null) {
                return false;
            }
        } else if (!this.cartId.equals(cart.cartId)) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        final int prime = 71;
        int result = prime * 1 + ((this.cartId == null) ? 0 : cartId.hashCode());
        return result;
    }

    public List getAttributesValues(String s) {
        List values = new ArrayList();
        values.add(cartId);
        values.add(s);
        values.add(getTotalCartItemsGrossValue());
        values.add(userId);
        return values;
    }
}




