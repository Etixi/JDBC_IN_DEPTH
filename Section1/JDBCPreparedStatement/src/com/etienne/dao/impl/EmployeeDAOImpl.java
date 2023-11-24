
////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

package com.etienne.dao.impl;

import com.etienne.dao.EmployeeDAO;
import com.etienne.model.Employee;
import com.etienne.util.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
	@Override
	public void createEmployee(Employee employee) {

		String sql = "INSERT INTO employee_table(employee_name,email,salary,date_of_joining,bonus) VALUES(?,?,?,?,?)";

		try (Connection cn = DBUtil.getConnection();
			 PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setString(1, employee.getEmployeeName());
			ps.setString(2, employee.getEmail());
			ps.setDouble(3, employee.getSalary());
			ps.setDate(4, new Date(employee.getDoj().getTime()));
			ps.setBigDecimal(5, employee.getBonus());

			int executeUpdate = ps.executeUpdate();

			if (executeUpdate == 1) {
				System.out.println("Employee is created");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {

		Employee employee = null;
		String sql = "SELECT * FROM employee_table WHERE employee_id=?";

		try (Connection cn = DBUtil.getConnection();
			 PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setInt(1, employeeId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int empId = rs.getInt("employee_id");
				String eName = rs.getString("employee_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				BigDecimal bonus = rs.getBigDecimal("bonus");
				Date date = rs.getDate("date_of_joining");

				employee = new Employee();
				employee.setEmployeeName(eName);
				employee.setBonus(bonus);
				employee.setDoj(date);
				employee.setEmail(email);
				employee.setEmployee_id(empId);
				employee.setSalary(salary);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public void updateEmployeeEmailById(String newEmail, Integer employeeId) {

		String sql = "UPDATE employee_table set email = ? where employee_id = ?";
		try (Connection cn = DBUtil.getConnection();
			 PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setString(1, newEmail);
			ps.setInt(2, employeeId);

			int executeUpdate = ps.executeUpdate();

			if (executeUpdate == 1) {
				System.out.println("Employee is email is updated...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {

		String sql = "DELETE FROM employee_table WHERE employee_id=?";
		try (Connection cn = DBUtil.getConnection();
			 PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setInt(1, employeeId);

			int executeUpdate = ps.executeUpdate();

			if (executeUpdate == 1) {
				System.out.println("Employee is email is deleted with ID : " + employeeId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getAllEmployeesInfo() {

		List<Employee> empList = new ArrayList<>();
		String SQL = "SELECT * FROM employee_table";
		try(Connection connection = DBUtil.getConnection();PreparedStatement ps = connection.prepareStatement(SQL)) {

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int empId = rs.getInt("employee_id");
				String eName = rs.getString("employee_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				BigDecimal bonus = rs.getBigDecimal("bonus");
				Date date = rs.getDate("date_of_joining");

				Employee employee = new Employee();
				employee.setEmployeeName(eName);
				employee.setBonus(bonus);
				employee.setDoj(date);
				employee.setEmail(email);
				employee.setEmployee_id(empId);
				employee.setSalary(salary);

				empList.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}
}
