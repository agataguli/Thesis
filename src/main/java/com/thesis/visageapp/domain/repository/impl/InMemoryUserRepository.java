package com.thesis.visageapp.domain.repository.impl;

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
                user = this.createUserByResponse(rs);
                this.listOfUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MysqlConnector.disconnect();
    }

    private User createUserByResponse(ResultSet rs) throws SQLException {
        User user = new User(
                rs.getString(StaticQueryParts.USERS_USER_ID), rs.getString(StaticQueryParts.USERS_LOGIN),
                rs.getString(StaticQueryParts.USERS_PASSWORD), rs.getString(StaticQueryParts.USERS_NAME),
                rs.getString(StaticQueryParts.USERS_SURNAME), rs.getString(StaticQueryParts.USERS_EMAIL),
                rs.getString(StaticQueryParts.USERS_PHONE_NUMBER), rs.getString(StaticQueryParts.USERS_COUNTRY),
                rs.getString(StaticQueryParts.USERS_POST_CODE), rs.getString(StaticQueryParts.USERS_CITY),
                rs.getString(StaticQueryParts.USERS_STREET), rs.getString(StaticQueryParts.USERS_ADDRESS_DETAILS),
                rs.getBoolean(StaticQueryParts.USERS_ACTIVE)
        );
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return this.listOfUsers;
    }

    @Override
    public User getUserWithId(String userId) throws IllegalAccessException {
        User userById = null;
        for (User user : this.listOfUsers) {
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
                for (User user : this.listOfUsers) {
                    if (criteriaCase.equalsIgnoreCase(user.getCity())) {
                        usersByCriteria.add(user);
                    }
                }
            }
        }
        return usersByCriteria;
    }

    @Override
    public String addUser(User user) throws SQLException {
        MysqlConnector.connect();
        String resultCode = StaticQueryParts.RESPONSE_CODE_SUCCESS;
        ResultSet rs = MysqlConnector.prepareStatement(StaticQueryParts.selectSingleQuery(
                StaticQueryParts.USERS_TAB_NAME, StaticQueryParts.USERS_LOGIN, user.getLogin()));
        if (rs.next()) {
            resultCode = StaticQueryParts.RESPONSE_CODE_ERROR_SIGNUP_LOGIN_DUPLICATE;
        } else {
            rs = MysqlConnector.prepareStatement(StaticQueryParts.selectSingleQuery(
                    StaticQueryParts.USERS_TAB_NAME, StaticQueryParts.USERS_USER_ID, user.getUserId()));
            if (rs.next()) {
                resultCode = StaticQueryParts.RESPONSE_CODE_ERROR_SIGNUP_PESEL_DUPLICATE;
            } else {
                rs = MysqlConnector.prepareStatement(StaticQueryParts.selectSingleQuery(
                        StaticQueryParts.USERS_TAB_NAME, StaticQueryParts.USERS_EMAIL, user.getEmail()));
                if (rs.next()) {
                    resultCode = StaticQueryParts.RESPONSE_CODE_ERROR_SIGNUP_EMAIL_DUPLICATE;
                } else {
                    String addQuery = StaticQueryParts.insertQuery(StaticQueryParts.USERS_TAB_NAME, user.getAttributesValues());
                    MysqlConnector.executeOnDatabase(addQuery);
                }
            }
        }
        return resultCode;
    }

    @Override
    public List<User> getUsersWithAvailableStatus(boolean isAvailable) {
        List<User> userList = new ArrayList<>();
        for (User user : this.listOfUsers) {
            if (user.isActive() == isAvailable) userList.add(user);
        }
        return userList;
    }

    @Override
    public User authenticateUser(String login, String password) throws SQLException {
        MysqlConnector.connect();
        String statement = StaticQueryParts.selectQuery(StaticQueryParts.USERS_TAB_NAME, StaticQueryParts.USERS_LOGIN, StaticQueryParts.USERS_PASSWORD, login, password);
        ResultSet rs = MysqlConnector.prepareStatement(statement);
        rs.next();
        User user = this.createUserByResponse(rs);
        this.listOfUsers.add(user);
        MysqlConnector.disconnect();
        if (user == null) user = User.newErrorUser();
        return user;
    }

    @Override
    public String updateUserData(User userDataToUpdate) throws SQLException {
        MysqlConnector.connect();
        String resultCode = StaticQueryParts.RESPONSE_CODE_SUCCESS;
        ResultSet rs = MysqlConnector.prepareStatement(StaticQueryParts.selectDoubleQuery(
                StaticQueryParts.USERS_TAB_NAME, StaticQueryParts.USERS_EMAIL, userDataToUpdate.getEmail(),
                StaticQueryParts.USERS_USER_ID, userDataToUpdate.getUserId(), false));
        if (rs.next()) {
            resultCode = StaticQueryParts.RESPONSE_CODE_ERROR_UPDATE_EMAIL_DUPLICATE;
            MysqlConnector.disconnect();
        } else {
            User user = this.authenticateUser(userDataToUpdate.getLogin(), userDataToUpdate.getPassword());
            if (user.getUserId().equals(StaticQueryParts.ERROR)) {
                resultCode = StaticQueryParts.RESPONSE_CODE_ERROR_UPDATE_INCORRECT_PASSWORD;
            } else {
                String updateQuery = StaticQueryParts.updateUserData(user);
                MysqlConnector.executeOnDatabase(updateQuery);
            }
        }
        MysqlConnector.disconnect();

        return resultCode;
    }


    /*
    public String updateUserData(User userDataToUpdate) throws SQLException {
        MysqlConnector.connect();
        String resultCode = StaticQueryParts.RESPONSE_CODE_SUCCESS;
        ResultSet rs = MysqlConnector.prepareStatement(StaticQueryParts.selectSingleQuery(
                StaticQueryParts.USERS_TAB_NAME, StaticQueryParts.USERS_EMAIL, userDataToUpdate.getEmail()));
        if (rs.next()) {
            resultCode = StaticQueryParts.RESPONSE_CODE_ERROR_UPDATE_EMAIL_DUPLICATE;
        } else {
            User userPassword = this.checkUserCredentials(userDataToUpdate.getLogin(), userDataToUpdate.getPassword());
            if (userPassword.equals(User.newErrorUser())) {
                resultCode = StaticQueryParts.RESPONSE_CODE_ERROR_UPDATE_INCORRECT_PASSWORD;
            }
            else {
                String updateQuery = StaticQueryParts.updateAllQuery(StaticQueryParts.USERS_TAB_NAME, userDataToUpdate.getAttributesValues());
                MysqlConnector.executeOnDatabase(updateQuery);
            }
        }
        return resultCode;
    }
     */
}
