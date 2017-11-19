package com.thesis.visageapp.service;

import com.thesis.visageapp.domain.Cart;

public interface CartService {
    Cart create(Cart cart);

    void delete(String cartId);

    Cart read(String cartId);

    void update(String cartId, Cart cart);
}
