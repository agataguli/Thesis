package com.thesis.visageapp.domain.repository;

import com.thesis.visageapp.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Agatka
 */
public interface UserRepository {

    List<User> getAllUsers();

    User getUserWithId(String userId) throws IllegalAccessException;

    Set<User> getUsersWithFilter(Map<String, List<String>> filterParams);

    void addUser(User user);

    List<User> getUsersWithAvailableStatus(boolean isAvailable);
}
