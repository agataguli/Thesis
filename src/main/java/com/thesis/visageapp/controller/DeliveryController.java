package com.thesis.visageapp.controller;

import com.thesis.visageapp.domain.Delivery;
import com.thesis.visageapp.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewDeliveryForm(@ModelAttribute("newDelivery") Delivery newDelivery) {
        return "addDelivery";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newDelivery") Delivery deliveryToBeAdded, ModelMap map, BindingResult result) throws SQLException, IllegalAccessException {
        String[] suppressedFields = result.getSuppressedFields();

        if (suppressedFields.length > 0) {
            throw new RuntimeException("No field bound: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        deliveryService.addDelivery(deliveryToBeAdded);
        return "redirect:/products/all";
    }
}
