
////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

package com.etienne.client;


import com.etienne.util.DBUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

public class ClientTest {

    public static void main(String[] args) {

        String sql = "CALL getEmployeeById(?)";

        try (Connection cn = DBUtil.getConnection();
             CallableStatement cs = cn.prepareCall(sql);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter employee ID::");
            int empId = scanner.nextInt();
            cs.setInt(1, empId);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                int empId2 = rs.getInt("employee_id");
                String eName = rs.getString("employee_name");
                String email = rs.getString("email");
                Double salary = rs.getDouble("salary");
                BigDecimal bonus = rs.getBigDecimal("bonus");

                System.out.println(empId2 + "\t" + eName + "\t" + salary + "\t" + email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
