package com.thesis.visageapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Agatka on 09.11.2017.
 */

@Controller
@RequestMapping(value = "rest/cart")
public class CartController {

    @RequestMapping
    public String get(HttpServletRequest httpServletRequest) {
        return "redirect:/cart/" + httpServletRequest.getSession(true).getId();
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public String getCart(@PathVariable(value = "cartId") String cartId, Model model) {
        model.addAttribute("cartId", cartId);
        return "cart";
    }

}
