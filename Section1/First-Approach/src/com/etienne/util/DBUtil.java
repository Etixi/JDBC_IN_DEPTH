package com.etienne.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
    private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USERNAME = "xxxxxxxxxxxx";
    private static final String DB_PASSWORD = "xxxxxxxxxxxxx";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbcdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    private static Connection connection = null;

    static {
        try {
            Class.forName(DB_DRIVER_CLASS);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
