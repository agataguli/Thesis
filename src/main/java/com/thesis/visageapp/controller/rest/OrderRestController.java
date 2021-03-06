package com.thesis.visageapp.controller.rest;

import com.thesis.visageapp.domain.Order;
import com.thesis.visageapp.domain.OrderItem;
import com.thesis.visageapp.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.thesis.visageapp.service.OrderService;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/{productId}/{quantity}")
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

    @RequestMapping(value = "/history/{userId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Order> getUserOrders(@PathVariable(value = "userId") String userId) throws SQLException {
        return orderService.getHistoryOrders(userId);
    }

    @RequestMapping(value = "/orderItems/items/{orderId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<OrderItem> getOrderItemsItselfForOrder(@PathVariable(value = "orderId") String orderId) {
        return orderService.getOrderItemsItselfForOrder(orderId);
    }

    @RequestMapping(value = "/orderItems/products/{orderId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Product> getOrderItemsProductsProductForOrder(@PathVariable(value = "orderId") String orderId) throws IllegalAccessException {
        return orderService.getOrderItemsProductsProductForOrder(orderId);
    }
}
