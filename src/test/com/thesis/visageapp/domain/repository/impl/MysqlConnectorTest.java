package com.thesis.visageapp.domain.repository.impl;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnectorTest {

    @Test
    public void connectionAndDisconnectionShouldThrowNoException() {
        // given
        MysqlConnector mysqlConnectorConnectAndDisconnect = new MysqlConnector();
        MysqlConnector mysqlConnectorOnlyDisconnect = new MysqlConnector();

        // when
        mysqlConnectorConnectAndDisconnect.connect();
        mysqlConnectorOnlyDisconnect.disconnect();
        mysqlConnectorConnectAndDisconnect.disconnect();

        // then
        // no exception
    }

    @Test
    public void disconnectionShouldThrowException() {
        // given
        MysqlConnector mysqlConnector = new MysqlConnector();

        // when
        mysqlConnector.disconnect();

        // then
        // no exception
    }

    @Test
    public void shouldReturnSomeNotEmptyQuery() throws SQLException {
        // given
        MysqlConnector mysqlConnector = new MysqlConnector();
        String adminSelector = "select * from admins";
        ResultSet myResultSet = null;

        // when
        mysqlConnector.connect();
        myResultSet = mysqlConnector.prepareStatement(adminSelector);

        // then
        Assert.assertNotNull(myResultSet);
        while(myResultSet.next()) {
            System.out.println(myResultSet.getString("name"));
        }
    }
}