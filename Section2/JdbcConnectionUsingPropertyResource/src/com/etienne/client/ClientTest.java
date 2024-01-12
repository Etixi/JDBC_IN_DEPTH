package com.etienne.client;

import com.etienne.util.DBUtil;

import java.sql.Connection;

public class ClientTest {

    public static void main(String[] args) {

        Connection connection = DBUtil.getConnection();
        if(connection != null) {
            System.out.println("JDBC:connection is taken ...");
        }

    }
}
