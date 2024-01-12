
////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

package com.etienne.client;


import com.etienne.dao.EmployeeDAO;
import com.etienne.dao.impl.EmployeeDAOImpl;
import com.etienne.model.Employee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ClientTest {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        // Employee employee = getEmployee();
        // employeeDAO.createEmployee(employee);
        // getEmployeeById(employeeDAO);
        //employeeDAO.updateEmployeeEmailById("martinaud@yahoo.com", 3);
        // employeeDAO.deleteEmployeeById(4);
        getAllEmployeesInfo(employeeDAO);

    }

    private static void getAllEmployeesInfo(EmployeeDAO employeeDAO) {
        List<Employee> employeeList = employeeDAO.getAllEmployeesInfo();
        employeeList.forEach(System.out::println);
    }

    private static void getEmployeeById(EmployeeDAO employeeDAO) {
        Employee employee1 = employeeDAO.getEmployeeById(1);
        if (employee1 != null) {
            System.out.println(employee1);
        } else {
            System.out.println("Employee doesn't exist");
        }
    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setBonus(new BigDecimal(290));
        employee.setDoj(new Date());
        employee.setEmployeeName("John");
        employee.setEmail("jonh.cs2016@yahoo.com");
        employee.setSalary(90000.00);
        return employee;
    }

}
