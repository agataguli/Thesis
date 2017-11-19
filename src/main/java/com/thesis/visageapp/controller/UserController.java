package com.thesis.visageapp.controller;

import com.thesis.visageapp.domain.User;
import com.thesis.visageapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/filter/{ByCriteria}", method = RequestMethod.GET)
    public String getUsersWithFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("users", userService.getUsersWithFilter(filterParams));
        return "users";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserWithId(@RequestParam("id") String userId, Model model) throws IllegalAccessException {
        model.addAttribute("user", userService.getUserWithId(userId));
        return "user";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewUserForm(@ModelAttribute("newUser") User newUser) {
        return "addUser";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewUserForm(@ModelAttribute("newUser") User userToBeAdded, ModelMap map,
                                        BindingResult result) throws SQLException {
        String[] suppressedFields = result.getSuppressedFields();

        if (suppressedFields.length > 0) {
            throw new RuntimeException("No field bound: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        userService.addUser(userToBeAdded);
        return "redirect:/users";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setDisallowedFields();
    }
}
