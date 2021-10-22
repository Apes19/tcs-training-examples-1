package com.tcs.dao;

import java.util.List;

import com.tcs.beans.Employee;

public interface EmployeeDao {
	public int save(Employee employee);
	public Employee updateEmployeeSalary(Employee employee, int id, double salary);
	public Employee updateEmployeeName(int id, String name);
	public Employee fetchEmployee(int id);
	public List<Employee> fetchEmployees();
	public List<Employee> getEmployeesOrderByName();
	public List<Employee> getEmployees();
}
