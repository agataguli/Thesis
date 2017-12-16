package com.thesis.visageapp.domain.repository;

import com.thesis.visageapp.domain.Cart;

import java.sql.SQLException;

public interface CartRepository {
    Cart create(Cart cart) throws SQLException;

    void delete(String cartId);

    Cart read(String cartId);

    void update(String cartId, Cart cart);
}
