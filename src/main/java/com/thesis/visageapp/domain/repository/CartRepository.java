package com.thesis.visageapp.domain.repository;

import com.thesis.visageapp.domain.Cart;

/**
 * Created by Agatka on 24.10.2017.
 */
public interface CartRepository {
    Cart create(Cart cart);

    void delete(String cartId);

    Cart read(String cartId);

    void update(String cartId, Cart cart);
}
