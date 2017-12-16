package com.thesis.visageapp.domain.repository.impl;

import com.thesis.visageapp.domain.Cart;
import com.thesis.visageapp.domain.repository.CartRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryCartRepository implements CartRepository {
    private String productId;
    private String name;
    private String category;
    private String brand;
    private Double grossValue;
    private Double netValue;
    private String description;
    private int quantity;
    private String imageLink;
    private boolean available = true;
    private Map<String, Cart> listOfCarts;

    public InMemoryCartRepository() {
        this.listOfCarts = new HashMap<>();
    }

    @Override
    public Cart create(Cart cart) throws SQLException {
        if (this.listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException("Cannot create cart with existing id:" + cart.getCartId());
        }
        this.listOfCarts.put(cart.getCartId(), cart);
        for (String s : cart.getCartItems()){
            String addQuery = StaticQueryParts.insertQuery(StaticQueryParts.CART_TAB_NAME, cart.getAttributesValues(s));
            MysqlConnector.executeOnDatabase(addQuery);
        }

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
