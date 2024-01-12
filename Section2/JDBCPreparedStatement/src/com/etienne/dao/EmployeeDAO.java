
////////////////////////////////////////////////////////////////////////////////
// Created By Etienne KOA
////////////////////////////////////////////////////////////////////////////////

package com.etienne.dao;

import com.etienne.model.Employee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface EmployeeDAO {

	public abstract void createEmployee(Employee employee);
	public abstract Employee getEmployeeById(Integer employeeId);
	public abstract void updateEmployeeEmailById(String newEmail,Integer employeeId);
	public abstract void deleteEmployeeById(Integer employeeId);
	public abstract List<Employee> getAllEmployeesInfo();

}
