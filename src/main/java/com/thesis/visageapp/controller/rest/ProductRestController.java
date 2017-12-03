package com.thesis.visageapp.controller;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/allM", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Product> listProductsM(Model model) {
        return productService.getAllProducts();
    }
}
