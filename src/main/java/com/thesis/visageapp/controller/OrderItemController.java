package com.thesis.visageapp.controller;


import com.thesis.visageapp.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/order/items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listOrderItems(Model model) throws SQLException {
        model.addAttribute("orderItems", orderItemService.getAllItemsForAllOrders());
        return "orderItems";
    }

    @RequestMapping(value = "/getItemsForOrder/{orderId}")
    public String getProductsForOrder(@PathVariable(value = "orderId") String orderId, Model model) throws SQLException {
        model.addAttribute("orderItems", orderItemService.getProductsForOrder(orderId));
        return "orderItems";
    }
}
