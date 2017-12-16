package com.thesis.visageapp.service.impl;

import com.thesis.visageapp.domain.Cart;
import com.thesis.visageapp.domain.repository.CartRepository;
import com.thesis.visageapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart create(Cart cart) throws SQLException {
        return this.cartRepository.create(cart);
    }

    @Override
    public void delete(String cartId) {
        this.cartRepository.delete(cartId);
    }

    @Override
    public Cart read(String cartId) {
        return this.cartRepository.read(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        this.cartRepository.update(cartId, cart);
    }
}
