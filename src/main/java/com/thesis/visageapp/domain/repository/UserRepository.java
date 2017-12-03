package com.thesis.visageapp.domain.repository;

import com.thesis.visageapp.domain.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserRepository {

    List<User> getAllUsers();

    User getUserWithId(String userId) throws IllegalAccessException;

    Set<User> getUsersWithFilter(Map<String, List<String>> filterParams);

    void addUser(User user) throws SQLException;

    List<User> getUsersWithAvailableStatus(boolean isAvailable);

    User authenticateUser(String login, String password) throws SQLException;
}
