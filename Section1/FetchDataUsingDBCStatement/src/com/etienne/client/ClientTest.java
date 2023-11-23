package com.etienne.client;

import com.etienne.util.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClientTest {

    public static void main(String[] args) {
       // getEmployeeId();
        getAllEmployeesInfo();
    }

    private static void getAllEmployeesInfo() {

        try(Connection connection = DBUtil.getConnection();
            Statement st = connection.createStatement();
        ) {

            String SQL= "select * from employee_table";
            ResultSet rs = st.executeQuery(SQL);

            while(rs.next()){
                int empId = rs.getInt("employee_id");
                String eName = rs.getString("employee_name");
                String email = rs.getString("email");
                Double salary = rs.getDouble("salary");
                BigDecimal bonus = rs.getBigDecimal("bonus");

                System.out.println(empId + "\t" + eName + "\t" + email + "\t" + salary + "\t" + bonus);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getEmployeeId() {

        try(Connection connection = DBUtil.getConnection();
            Statement st = connection.createStatement();
        ) {

            String SQL= "select * from employee_table where employee_id=1";
            ResultSet rs = st.executeQuery(SQL);

            if(rs.next()){
                int empId = rs.getInt("employee_id");
                String eName = rs.getString("employee_name");
                String email = rs.getString("email");
                Double salary = rs.getDouble("salary");
                BigDecimal bonus = rs.getBigDecimal("bonus");

                System.out.println(empId + "\t" + eName + "\t" + email + "\t" + salary + "\t" + bonus);
            } else {
                System.out.println("Employee doesn't exit with provided ID ...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
