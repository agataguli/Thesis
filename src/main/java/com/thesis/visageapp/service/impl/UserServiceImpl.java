package com.thesis.visageapp.service.impl;

import com.thesis.visageapp.domain.User;
import com.thesis.visageapp.domain.repository.UserRepository;
import com.thesis.visageapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserWithId(String userId) throws IllegalAccessException {
        return userRepository.getUserWithId(userId);
    }

    @Override
    public Set<User> getUsersWithFilter(Map<String, List<String>> filterParams) {
        return userRepository.getUsersWithFilter(filterParams);
    }

    @Override
    public String addUser(User user) throws SQLException {
        return userRepository.addUser(user);
    }

    @Override
    public List<User> getUsersWithAvailableStatus(boolean isAvailable) {
        return userRepository.getUsersWithAvailableStatus(isAvailable);
    }

    @Override
    public User authenticateUser(String login, String password) throws SQLException {
        return userRepository.authenticateUser(login, password);
    }
}
