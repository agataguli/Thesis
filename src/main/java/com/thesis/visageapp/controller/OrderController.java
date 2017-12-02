package com.thesis.visageapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.thesis.visageapp.service.OrderService;

import java.sql.SQLException;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/{productId}/{quantity}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String processOrder(@PathVariable(value = "productId") String productId, @PathVariable(value = "quantity") int quantity) throws SQLException {
        orderService.processOrder(productId, quantity);
        return "redirect:/products/all";
    }
}
