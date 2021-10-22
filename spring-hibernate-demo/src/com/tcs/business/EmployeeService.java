package com.tcs.business;

import java.util.List;

import com.tcs.beans.Employee;
import com.tcs.exception.EmployeeNotFoundException;

public interface EmployeeService {
	// use the id from the DAO and return the employee
	public Employee store(Employee employee);
	// if employee from DAO returns null then throw exception
	public Employee findEmployeeById(int id) throws EmployeeNotFoundException;
	// update method for salary 
	public Employee updateEmployeeSalary(Employee employee, int id, double salary) throws EmployeeNotFoundException;
	// update method for name 
	public Employee updateEmployeeName(int id, String name) throws EmployeeNotFoundException;
	// get all the employees
	public List<Employee> getEmployees();
	// get all the employees sorting the names
	public List<Employee> getEmployeesOrderByName();
}
