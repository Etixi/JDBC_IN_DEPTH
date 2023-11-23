package com.etienne.client;

import com.etienne.util.DBUtil;

import java.sql.Connection;
import java.sql.Statement;

public class ClientTest {

    public static void main(String[] args) {
         createEmployee();
        // updateEmployeeEmailById();
        //deleteEmployeeById();
    }

    private static void deleteEmployeeById() {

        try(Connection connection = DBUtil.getConnection();
            Statement st = connection.createStatement()
        ) {

            String SQLINSERT = "delete from employee_table where employee_id=2";

            int executeUpdate = st.executeUpdate(SQLINSERT);

            if(executeUpdate == 1){
                System.out.println("Employee is deleted ...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateEmployeeEmailById() {

        try(Connection connection = DBUtil.getConnection();
            Statement st = connection.createStatement()
        ) {

            String SQLINSERT = "update employee_table set email='paul.cs2017@yahoo.com' where employee_id=2";

            int executeUpdate = st.executeUpdate(SQLINSERT);

            if(executeUpdate == 1){
                System.out.println("Email is updated ...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void createEmployee() {

        try(Connection connection = DBUtil.getConnection();
            Statement st = connection.createStatement()
        ) {

            String SQLINSERT = "insert into employee_table(employee_name, email, salary, date_of_joining, bonus) "
                    + "values('John', 'john.cs2008@yahoo.com', 65000.00, '2016-05-11', 550.00)";

            int executeUpdate = st.executeUpdate(SQLINSERT);

            if(executeUpdate == 1){
                System.out.println("Employee is created ...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
