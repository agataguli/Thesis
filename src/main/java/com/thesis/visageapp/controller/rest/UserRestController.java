package com.thesis.visageapp.controller.rest;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.thesis.visageapp.domain.User;
import com.thesis.visageapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/loginM", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User authenticateUser(@RequestBody User requestBody) throws SQLException {
        return userService.authenticateUser(requestBody.getLogin(), requestBody.getPassword());
    }


}
