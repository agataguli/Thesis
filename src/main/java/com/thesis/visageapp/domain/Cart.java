package com.thesis.visageapp.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private String cartId;
    private Double totalCartItemsGrossValue;
    private Map<String, CartItem> cartItems;

    public Cart() {
        cartItems = new HashMap<String, CartItem>();
        totalCartItemsGrossValue = Double.valueOf(0);
    }

    public Cart(String cartId) {
        this.cartId = cartId;
    }

    public void addCartItem(CartItem cartItemToAdd) {
        String itemProductId = cartItemToAdd.getProduct().getProductId();
        if (cartItems.containsKey(itemProductId)) {
            CartItem cartItemAlreadyInCart = cartItems.get(itemProductId);
            cartItemAlreadyInCart.setQuantity(cartItemAlreadyInCart.getQuantity() + cartItemToAdd.getQuantity());
            cartItems.put(itemProductId, cartItemAlreadyInCart);
        } else cartItems.put(itemProductId, cartItemToAdd);
        this.updateTotalCartItemsGrossValue();
    }

    public void removeCartItem(CartItem cartItemToRemove) {
        cartItems.remove(cartItemToRemove.getProduct().getProductId());
        this.updateTotalCartItemsGrossValue();
    }

    private void updateTotalCartItemsGrossValue() {
        this.totalCartItemsGrossValue = Double.valueOf(0);
        for(CartItem cartItem: cartItems.values()) {
            this.totalCartItemsGrossValue +=cartItem.getTotalMultipliedItemGrossValue();
        }
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

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;
        if(this.cartId == null) {
            if(cart.cartId != null) {
                return false;
            }
        } else if(!this.cartId.equals(cart.cartId)) {
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
}
