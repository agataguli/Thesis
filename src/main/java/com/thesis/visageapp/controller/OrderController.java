package com.thesis.visageapp.controller;

import com.thesis.visageapp.service.DeliveryService;
import com.thesis.visageapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listOrders(Model model) throws SQLException {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String getOrderWithId(@RequestParam("id") String orderId, Model model) throws IllegalAccessException {
        model.addAttribute("order", orderService.getOrderWithId(orderId));
        return "order";
    }

    @RequestMapping(value = "/changeStatus/{status}/{orderId}")
    public String changeOrderStatus(@PathVariable(value = "status") String status, @PathVariable(value = "orderId") String orderId) throws SQLException {
        orderService.changeOrderStatus(status, orderId);
        return "redirect:/orders/all";
    }
}
