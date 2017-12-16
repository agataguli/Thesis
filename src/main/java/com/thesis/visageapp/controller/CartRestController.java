package com.thesis.visageapp.controller;

import com.thesis.visageapp.domain.Cart;
import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.service.CartService;
import com.thesis.visageapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/cart")
public class CartRestController {
    private CartService cartService;

    private ProductService productService;

    @Autowired
    public CartRestController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable String productId, HttpServletRequest request) throws IllegalAccessException, SQLException {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        if(cart== null) {
            cart = cartService.create(new Cart(sessionId));
        }
        Product product = productService.getProductWithId(productId);
        if(product == null) {
            throw new IllegalArgumentException("Cannot add to cart product with non existing productId: "+productId);
        }
        cart.addCartItem((product));
        cartService.update(sessionId, cart);
    }

    @RequestMapping(value ="/newM", method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Cart create(@RequestBody Cart cart) throws SQLException {
        return cartService.create(cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody
    Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable String productId, HttpServletRequest request) throws IllegalAccessException, SQLException {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        if(cart== null) {
            cart = cartService.create(new Cart(sessionId));
        }
        Product product = productService.getProductWithId(productId);
        if(product == null) {
            throw new IllegalArgumentException("Cannot remove from cart item with non existing productId: " +productId);
        }
        cart.removeCartItem(product);
        cartService.update(sessionId, cart);
    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
        cartService.update(cartId, cart);
    }

}
