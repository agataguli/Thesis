package com.thesis.visageapp.domain.repository.impl;

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
    public final static String PROD_AVAILABLE = "available";

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

    // combinations
    public static String updateQuery(String tableName, String columnName, String newValue, String condition) {
        return UPDATE + tableName + SET + columnName + " = " + newValue + WHERE + condition;
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
}
