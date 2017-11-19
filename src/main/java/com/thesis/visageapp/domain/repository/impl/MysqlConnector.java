package com.thesis.visageapp.domain.repository.impl;

import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.util.Properties;

public class MysqlConnector {
    private static Connection CONNECTION;

    @Value("${db.mysql.driver}")
    private static String DatabaseDriver = "com.mysql.jdbc.Driver";

    @Value("${db.mysql.url}")
    private static String DatabaseUrl = "jdbc:mysql://localhost/makemeup";

    @Value("${db.mysql.user}")
    private static String DatabaseUser = "root";

    @Value("${db.mysql.password}")
    private static String DatabasePassword = "";

    public MysqlConnector() {
        Logger.logMsg(0, "Initialization of connector");
    }

    public static Connection connect() {
        if (CONNECTION == null) {
            try {
                Class.forName(DatabaseDriver);
                CONNECTION = DriverManager.getConnection(DatabaseUrl, DatabaseUser, DatabasePassword);
                Logger.logMsg(0, "Database is connected");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return CONNECTION;
    }

    public static void disconnect() {
        if (CONNECTION != null) {
            try {
                CONNECTION.close();
                CONNECTION = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet prepareStatement(String sqlQuery) {
        ResultSet myDbResultSet = null;
        if (CONNECTION == null) {
            throw new IllegalStateException("Cannot prepare statement without CONNECTION to database");
        }
        try {
            Statement myDbStatement = connect().createStatement();
            myDbResultSet = myDbStatement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myDbResultSet;
    }

    public static void executeOnDatabase(String sqlQuery) throws SQLException {
        connect().createStatement().executeUpdate(sqlQuery);
        disconnect();
    }
}
