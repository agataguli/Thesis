package com.thesis.visageapp.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.thesis.visageapp.service.OrderService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/{productId}/{quantity}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String processOrder(@PathVariable(value = "productId") String productId, @PathVariable(value = "quantity") int quantity) throws SQLException {
        orderService.processOrder(productId, quantity);
        return "redirect:/products/all";
    }

    @RequestMapping(value = "/cart/processOrderM/{userId}", method = RequestMethod.POST)
    public String orderProductsFromCart(@RequestBody List<String> productsIds,
                                        @PathVariable(value = "userId") String userId) throws SQLException, IllegalAccessException {
        return orderService.order(productsIds, userId);
    }
}