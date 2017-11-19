package com.thesis.visageapp.domain.repository.impl;

import com.thesis.visageapp.domain.Product;
import com.thesis.visageapp.domain.User;
import com.thesis.visageapp.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private List<User> listOfUsers = new ArrayList<>();

    public InMemoryUserRepository() {
        this.takeAllUsersFromDatabase();
    }

    private void takeAllUsersFromDatabase() {
        MysqlConnector.connect();
        ResultSet rs = MysqlConnector.prepareStatement(StaticQueryParts.SELECT_ALL_QUERY + StaticQueryParts.USERS_TAB_NAME);
        User user;
        try {
            while (rs.next()) {
                user = new User(
                        rs.getString(StaticQueryParts.USERS_USER_ID), rs.getString(StaticQueryParts.USERS_LOGIN),
                        rs.getString(StaticQueryParts.USERS_PASSWORD), rs.getString(StaticQueryParts.USERS_NAME),
                        rs.getString(StaticQueryParts.USERS_SURNAME), rs.getString(StaticQueryParts.USERS_EMAIL),
                        rs.getString(StaticQueryParts.USERS_PHONE_NUMBER), rs.getString(StaticQueryParts.USERS_COUNTRY),
                        rs.getString(StaticQueryParts.USERS_POST_CODE), rs.getString(StaticQueryParts.USERS_CITY),
                        rs.getString(StaticQueryParts.USERS_STREET), rs.getString(StaticQueryParts.USERS_ADDRESS_DETAILS),
                        rs.getBoolean(StaticQueryParts.USERS_ACTIVE)
                );
                this.listOfUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MysqlConnector.disconnect();
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
    public void addUser(User user) throws SQLException {
        listOfUsers.add(user);
        String addQuery = StaticQueryParts.insertQuery(StaticQueryParts.USERS_TAB_NAME, user.getAttributesValues());
        MysqlConnector.executeOnDatabase(addQuery);

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
