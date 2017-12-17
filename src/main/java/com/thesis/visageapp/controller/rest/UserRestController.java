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

    @RequestMapping(value = "/loginM", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public User authenticateUser(@RequestBody User requestBody) throws SQLException {
        return userService.authenticateUser(requestBody.getLogin(), requestBody.getPassword());
    }

    @RequestMapping(value = "/signupM", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String signupUser(@RequestBody User newUserRequestBody) throws SQLException {
        return userService.addUser(newUserRequestBody);
    }

    @RequestMapping(value = "/updateM", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateUserData(@RequestBody User userDataToUpdate) throws SQLException {
        return userService.updateUserData(userDataToUpdate);
    }

    @RequestMapping(value = "/changepassM", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String updateUserPassword(@RequestBody User userPart) throws SQLException {
        return userService.updateUserPassword(userPart);
    }

    @RequestMapping(value = "/deleteM", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String deleteUserAccount(@RequestBody User userToDelete) throws SQLException {
        return userService.deleteUserAccount(userToDelete);
    }
}
