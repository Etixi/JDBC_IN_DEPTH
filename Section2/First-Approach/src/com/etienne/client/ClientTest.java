package com.etienne.client;

import com.etienne.util.DBUtil;
import com.etienne.util.DBUtil2;
import com.etienne.util.DBUtil3;

import java.sql.Connection;

public class ClientTest {

    public static void main(String[] args) {

        Connection connection = DBUtil.getConnection();
        if(connection != null) {
            System.out.println("JDBC:connection is taken ...");
        }
        /*Connection connection2 = DBUtil2.getConnection();
        if(connection2 != null) {
            System.out.println("JDBC:connection is taken ...");
        }*/

     /*   Connection connection3 = DBUtil3.getConnection();
        if(connection3 != null) {
            System.out.println("JDBC:connection is taken ...");
        }*/
    }
}
