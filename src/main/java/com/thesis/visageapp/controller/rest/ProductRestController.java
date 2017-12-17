package com.thesis.visageapp.controller.rest;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.ProductFilter;
import com.thesis.visageapp.domain.User;
import com.thesis.visageapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/allM", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> listProductsM(Model model) {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/favM/add/{userId}/{productId}",
            method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String addProductToUserFavProductList(
            @PathVariable(value = "userId") String userId, @PathVariable(value = "productId") String productId)
            throws SQLException {
        return productService.addProductToUserFavProductList(userId, productId);
    }

    @RequestMapping(value = "/filterM", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List getFilteredProducts(@RequestBody ProductFilter requestBody) throws SQLException {
        return productService.getFilteredProducts(requestBody);
    }

    @RequestMapping(value = "/favM/{userId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List getUserFavProducts(@PathVariable(value = "userId") String userId) throws SQLException {
        return productService.getUserFavProducts(userId);
    }

    @RequestMapping(value = "/favM/remove/{userId}/{productId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String removeProductFromUserFavProductList(@PathVariable(value = "userId") String userId, @PathVariable(value = "productId") String productId) throws SQLException {
        return productService.removeProductToUserFavProductList(userId, productId);
    }
}
