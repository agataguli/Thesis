package com.thesis.visageapp.domain.repository.impl;

import com.thesis.visageapp.domain.User;

import java.util.List;

public class StaticQueryParts {
    // default header query parts
    public final static String SELECT_ALL_QUERY = "select * from ";
    public final static String SELECT = "select";
    public final static String SET = " set ";
    public final static String UPDATE = "update ";
    public final static String WHERE = " where ";
    public final static String INSERT = "insert ";
    public final static String VALUES = " values ";
    public final static String AND = " and ";
    public final static String OR = " or ";
    public final static String DELETE = "delete ";
    public final static String FROM = " from ";

    // table admins
    public final static String ADMINS_TAB_NAME = "admins";
    public final static String[] ADMINS_COLUMNS = getAdminsColumnNames();
    public final static String ADMINS_ADMIN_ID = "adminId";
    public final static String ADMINS_LOGIN = "login";
    public final static String ADMINS_PASSWORD = "password";
    public final static String ADMINS_PERMISSION_STATUS = "permissionStatus";
    public final static String ADMINS_NAME = "name";
    public final static String ADMINS_SURNAME = "surname";
    public final static String ADMINS_EMAIL = "email";
    public final static String ADMINS_PHONE_NUMBER = "phoneNumber";
    public final static String ADMINS_ACTIVE = "active";

    // table products
    public final static String PROD_TAB_NAME = "products";
    public final static String PROD_PRODUCT_ID = "productId";
    public final static String PROD_NAME = "name";
    public final static String PROD_CATEGORY = "category";
    public final static String PROD_BRAND = "brand";
    public final static String PROD_GROSS_VALUE = "grossValue";
    public final static String PROD_NET_VALUE = "netValue";
    public final static String PROD_DESCRIPTION = "description";
    public final static String PROD_QUANTITY = "quantity";
    public final static String PROD_IMAGE_LINK = "imageLink";
    public final static String PROD_AVAILABLE = "available";
    public static final String PROD_CATEGORY_BRUSHES = "PĘDZLE";
    public static final String PROD_CATEGORY_FURNITURE = "WYPOSAŻENIE";
    public static final String PROD_CATEGORY_ACCESSORIES = "AKCESORIA";

    //table users
    public final static String USERS_TAB_NAME = "users";
    public final static String USERS_USER_ID = "userId";
    public final static String USERS_LOGIN = "login";
    public final static String USERS_PASSWORD = "password";
    public final static String USERS_NAME = "name";
    public final static String USERS_SURNAME = "surname";
    public final static String USERS_EMAIL = "email";
    public final static String USERS_PHONE_NUMBER = "phoneNumber";
    public final static String USERS_COUNTRY = "country";
    public final static String USERS_POST_CODE = "postCode";
    public final static String USERS_CITY = "city";
    public final static String USERS_STREET = "street";
    public final static String USERS_ADDRESS_DETAILS = "addressDetails";
    public final static String USERS_ACTIVE = "active";
    public static final String ERROR = "ERROR";

    //table cart

    public final static String CART_TAB_NAME = "cart";

    public static final String RESPONSE_CODE_SUCCESS = "200";
    public static final String RESPONSE_CODE_FAIL = "201";

    public static final String RESPONSE_CODE_ERROR_SIGNUP_LOGIN_DUPLICATE = "300";
    public static final String RESPONSE_CODE_ERROR_SIGNUP_PESEL_DUPLICATE = "301";
    public static final String RESPONSE_CODE_ERROR_SIGNUP_EMAIL_DUPLICATE = "302";

    public static final String RESPONSE_CODE_ERROR_UPDATE_INCORRECT_PASSWORD = "400";
    public static final String RESPONSE_CODE_ERROR_UPDATE_EMAIL_DUPLICATE = "401";

    public static final String RESPONSE_CODE_ERROR_INCORRECT_OLD_PASSWORD = "501";

    // combinations
    public static String updateQuery(String tableName, String columnName, String newValue, String condition) {
        return UPDATE + tableName + SET + columnName + " = " + newValue + WHERE + condition;
    }

    public static String selectQuery(String tableName, String columnName1, String columnName2, String condition1, String condition2) {
        return SELECT_ALL_QUERY + tableName + WHERE + columnName1 + "='" + condition1 + "'" + AND + columnName2 + "='" + condition2 + "'";
    }

    public static String selectSingleQuery(String tableName, String columnName1, String condition1) {
        return SELECT_ALL_QUERY + tableName + WHERE + columnName1 + "='" + condition1 + "'";
    }

    public static String selectDoubleQuery(String tableName, String cN1, String cD1, String cN2, String cD2, boolean b) {
        String sign;
        if (b) sign = "='";
        else sign = "!='";
        String query = selectSingleQuery(tableName, cN1, cD1) + AND + cN2 + sign + cD2 + "'";
        return query;
    }

    public static String insertQuery(String tableName, List values) {
        String sqlQuery = INSERT + tableName + VALUES + "(";
        for (Object value : values) {
            if (value == Boolean.FALSE) value = 0;
            else if (value == Boolean.TRUE) value = 1;
            sqlQuery = sqlQuery + "'" + String.valueOf(value) + "',";
        }
        sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 1) + ")";
        return sqlQuery;
    }

    // helpers
    private static String[] getAdminsColumnNames() {
        String[] list = {ADMINS_ADMIN_ID, ADMINS_LOGIN, ADMINS_PASSWORD, ADMINS_PERMISSION_STATUS, ADMINS_NAME,
                ADMINS_SURNAME, ADMINS_EMAIL, ADMINS_PHONE_NUMBER, ADMINS_ACTIVE};
        return list;
    }

    public static String buildCondition(String columnName, String value) {
        return "`" + columnName + "` = " + "'" + value + "'";
    }

    public static String updateUserData(User user) {
        String sqlQuery = UPDATE + USERS_TAB_NAME + SET + "`" +
                USERS_NAME + "`='" + user.getName() + "', `" +
                USERS_SURNAME + "`='" + user.getSurname() + "', `" +
                USERS_EMAIL + "`='" + user.getEmail() + "', `" +
                USERS_PHONE_NUMBER + "`='" + user.getPhoneNumber() + "', `" +
                USERS_COUNTRY + "`='" + user.getCountry() + "', `" +
                USERS_POST_CODE + "`='" + user.getPostCode() + "', `" +
                USERS_STREET + "`='" + user.getStreet() + "', `" +
                USERS_ADDRESS_DETAILS + "`='" + user.getAddressDetails() + "' " +
                WHERE + "`" + USERS_USER_ID + "`='" + user.getUserId() + "'";
        return sqlQuery;
    }

    public static String updateUserPassword(String userId, String newValue) {
        String sqlQuery = UPDATE + USERS_TAB_NAME + SET + "`" +
                USERS_PASSWORD + "`='" + newValue + "' " +
                WHERE + "`" + USERS_USER_ID + "`='" + userId + "'";
        return sqlQuery;
    }

    public static String removeUser(String userId) {
        return DELETE + FROM + USERS_TAB_NAME + " " + WHERE + USERS_USER_ID + "='" + userId +"'";
    }
}
