package com.thesis.visageapp.domain.repository.impl;

import com.thesis.visageapp.domain.User;
import com.thesis.visageapp.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Agatka
 */
@Repository
public class InMemoryUserRepository implements UserRepository {
    private List<User> listOfUsers = new ArrayList<>();

    // TODO: replace this fake repository with some JDBC solution, best Hibernate.
    public InMemoryUserRepository() {
        // TODO: mocked users
        User user1 = new User("1", "testLogin1", "Perf123", "NameTest1", "SurnameTest1",
                "test@example.com", "111222333","Poland","22-300","Krasnystaw",
                "Testowa", "12A/8", true);
        User user2 = new User("2", "testLogin2", "Perf123", "NameTest2", "SurnameTest2",
                "test@example.com", "111222333","Poland","22-300","Krasnystaw",
                "Testowa", "200B/8", false);
        listOfUsers.add(user1);
        listOfUsers.add(user2);
    }

    @Override
    public List<User> getAllUsers() {
        return listOfUsers;
    }

    @Override
    public User getUserWithId(String userId) throws IllegalAccessException {
        User userById = null;
        for (User user : listOfUsers) {
            if (user != null && user.getUserId() != null && user.getUserId().equals(userId)) {
                userById = user;
                break;
            }
        }
        if (userById == null) {
            // TODO: move all messsages and strings to property file!
            throw new IllegalAccessException("No user with id:" + userId);
        }
        return userById;
    }

    @Override
    public Set<User> getUsersWithFilter(Map<String, List<String>> filterParams) {
        // TODO: test this and write to filter users in case of available status and city etc info
        // needed to making delivery
        Set<User> usersByCriteria = new HashSet<>();
        Set<String> criteria = filterParams.keySet();

        if (criteria.contains("city")) {
            for (String criteriaCase : filterParams.get("city")) {
                for (User user : listOfUsers) {
                    if (criteriaCase.equalsIgnoreCase(user.getCity())) {
                        usersByCriteria.add(user);
                    }
                }
            }
        }
        return usersByCriteria;
    }

    @Override
    public void addUser(User user) {
        listOfUsers.add(user);
    }

    @Override
    public List<User> getUsersWithAvailableStatus(boolean isAvailable) {
        List<User> userList = new ArrayList<>();
        for (User user : listOfUsers) {
            if (user.isActive() == isAvailable) userList.add(user);
        }
        return userList;
    }
}
