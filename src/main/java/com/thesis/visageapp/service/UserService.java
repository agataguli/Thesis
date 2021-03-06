package com.thesis.visageapp.service;

import com.thesis.visageapp.domain.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {
    List<User> getAllUsers();

    User getUserWithId(String userId) throws IllegalAccessException;

    Set<User> getUsersWithFilter(Map<String, List<String>> filterParams);

    String addUser(User user) throws SQLException;

    List<User> getUsersWithAvailableStatus(boolean isAvailable);

    User authenticateUser(String login, String password) throws SQLException;

    String updateUserData(User userDataToUpdate) throws SQLException;

    String updateUserPassword(User userPart) throws SQLException;

    String deleteUserAccount(User userToRemove) throws SQLException;
}
