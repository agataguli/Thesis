package com.thesis.visageapp.controller;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getProductById(@RequestParam("id") String productId, Model model)
            throws IllegalAccessException {
        model.addAttribute("product", productService.getProductWithId(productId));
        return "product";
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
        model.addAttribute("products", productService.getProductsWithCategory(productCategory));
        return "products";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping(value = "/toOrderProduct", method = RequestMethod.GET)
    public String getProductsIfAvailable(Model model) {
        model.addAttribute("products", productService.getProductsWithAvailableStatus(true));
        return "products";
    }

    @RequestMapping(value = "/orderProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String getOrderProductWithId(@RequestParam("id") String productId, Model model) throws IllegalAccessException {
        productService.orderProduct(productId);
        return "redirect:/products/all";
    }

    @RequestMapping(value = "/changeAvailability")
    public String changeAvailability(@RequestParam("id") String productId, Model model) throws IllegalAccessException, SQLException {
        productService.changeAvailability(productId);
        String productName = productService.getProductWithId(productId).getName();
        if(productService.getProductWithId(productId).isAvailable()){
            return "redirect:/send?id=" + productId;
        }
        return "redirect:/products/all";
    }

    @RequestMapping(value = "/filter/{ByCriteria}", method = RequestMethod.GET)
    public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsWithFilter(filterParams));
        return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
        return "addProduct";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded, ModelMap map, BindingResult result) throws SQLException {
        String[] suppressedFields = result.getSuppressedFields();

        if (suppressedFields.length > 0) {
            throw new RuntimeException("No field bound: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        productService.addProduct(productToBeAdded);
        return "redirect:/products/all";
    }

    @RequestMapping(value = "/updateQuantityByDelivered", method = RequestMethod.GET)
    public String updateQuantityByDelivered(@ModelAttribute("updateQuantityByDelivered") Product productToUpdate) {
        return "updateQuantityByDelivered";
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public String updateQuantityByDelivered(@RequestParam("id") String productId, @ModelAttribute("updateQuantityByDelivered") Integer quantity, ModelMap map, BindingResult result){
        String[] suppressedFields = result.getSuppressedFields();

        if (suppressedFields.length > 0) {
            throw new RuntimeException("No field bound: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        productService.updateQuantityByDelivered(productId, quantity);
        return "redirect:/products/all";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setDisallowedFields();
    }
}
