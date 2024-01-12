
////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

package com.etienne.client;


import com.etienne.util.DBUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;

public class ClientTest {

    public static void main(String[] args) {

        String SQL = "{?=CALL getAvg(?,?)}";
        try(Connection connection = DBUtil.getConnection();
            CallableStatement cs = connection.prepareCall(SQL);
            Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter first Number::");
            int n1 = scanner.nextInt();
            System.out.println("Enter Second Number::");
            int n2 = scanner.nextInt();

            cs.registerOutParameter(1, Types.INTEGER);

            cs.setInt(2, n1);
            cs.setInt(3, n2);

            cs.execute();

            System.out.println(cs.getInt(1));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
