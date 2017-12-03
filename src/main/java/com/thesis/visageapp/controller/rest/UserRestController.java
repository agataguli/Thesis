package com.thesis.visageapp.controller.rest;

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

    @RequestMapping(value = "/loginM/{login}/{password}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public User authenticateUser(@PathVariable(value = "login") String login, @PathVariable(value = "password") String password) throws SQLException {
        return userService.authenticateUser(login,password);
    }
}
