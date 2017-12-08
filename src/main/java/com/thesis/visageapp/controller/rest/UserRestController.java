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
//consumes = "application/json"
   @Autowired
    private UserService userService;

    @RequestMapping(value = "/loginTest/", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User authenticateUserTestJson(@RequestBody User user) throws SQLException {
        User user2 = new User();
        //user2 = user;
          return userService.authenticateUser(user.getLogin(), user.getPassword());
    }



    @RequestMapping(value = "/loginTest", method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User authenticateUserTestJson123(@RequestBody User requestBody) throws SQLException {
        User user2 = new User();
        //user2 = user;
        return new User();//userService.authenticateUser(user.getLogin(), user.getPassword());
    }




}
