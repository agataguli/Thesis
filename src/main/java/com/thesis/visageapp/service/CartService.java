package com.thesis.visageapp.service;

import com.thesis.visageapp.domain.Cart;

import java.sql.SQLException;

public interface CartService {
    Cart create(Cart cart) throws SQLException;

    void delete(String cartId);

    Cart read(String cartId);

    void update(String cartId, Cart cart);
}
