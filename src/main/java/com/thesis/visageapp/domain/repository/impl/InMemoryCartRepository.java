package com.thesis.visageapp.domain.repository.impl;

import com.thesis.visageapp.domain.Cart;
import com.thesis.visageapp.domain.repository.CartRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Agatka on 24.10.2017.
 */
@Repository
public class InMemoryCartRepository implements CartRepository {

    private Map<String, Cart> listOfCarts;

    public InMemoryCartRepository() {
        this.listOfCarts = new HashMap<>();
    }


    @Override
    public Cart create(Cart cart) {
        if (this.listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException("Cannot create cart with existing id:" + cart.getCartId());
        }
        this.listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    @Override
    public void delete(String cartId) {
        if (this.listOfCarts.keySet().contains(cartId)) {
            listOfCarts.remove(cartId);
        } else {
            throw new IllegalArgumentException("Cannot delete cart with non existing id: " + cartId);
        }
    }

    @Override
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        if (this.listOfCarts.keySet().contains(cartId)) {
            listOfCarts.put(cartId, cart);
        } else {
            throw new IllegalArgumentException("Cannot update cart with non existing id: " + cartId);
        }
    }
}
