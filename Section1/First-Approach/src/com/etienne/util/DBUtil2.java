package com.etienne.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil2 {
    private static final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USERNAME = "Etienne";
    private static final String DB_PASSWORD = "Caroline1995@";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbcdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    private static Connection connection = null;

    static {
        try {
            Class.forName(DB_DRIVER_CLASS);
            Properties properties = new Properties();
            properties.put("user", DB_USERNAME);
            properties.put("password", DB_PASSWORD);

            connection = DriverManager.getConnection(DB_URL, properties);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
