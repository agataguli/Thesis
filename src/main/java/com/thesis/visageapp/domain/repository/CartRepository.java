package com.thesis.visageapp.domain.repository;

import com.thesis.visageapp.domain.Cart;

public interface CartRepository {
    Cart create(Cart cart);

    void delete(String cartId);

    Cart read(String cartId);

    void update(String cartId, Cart cart);
}
