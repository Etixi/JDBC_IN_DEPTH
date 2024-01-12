
////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

package com.etienne.client;


import com.etienne.util.DBUtil;

import com.etienne.util.DBUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class ClientTest {

    public static void main(String[] args) {

        String UPDATESQL = "CALL updateSaleBy(?,?)";
        try(Connection connection = DBUtil.getConnection();
            CallableStatement cs = connection.prepareCall(UPDATESQL)) {

            cs.setDouble(1, 70000.00);
            cs.setInt(2,1);
            cs.addBatch();

            cs.setDouble(1, 95000.00);
            cs.setInt(2,3);
            cs.addBatch();

            cs.setDouble(1, 75000.00);
            cs.setInt(2,5);
            cs.addBatch();


            int[] executeBatch = cs.executeBatch();
            for (int i : executeBatch){
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
