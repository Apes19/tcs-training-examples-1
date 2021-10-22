package com.tcs.dao;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.beans.Employee;

@Repository
public class EmployeeDaoImpV1 implements EmployeeDao {

	@Autowired
	private HibernateTemplate template;
	private EmployeeDao employeeDao;
	
	
	@Override
	public int save(Employee employee) {
		int key = (Integer)template.save(employee);
		return key;
	}

	// Assignment
	@Override
	public Employee updateEmployeeSalary(Employee employee, int id, double salary) {
		employee = template.get(Employee.class, id);
        employee.setSalary(salary);       	
        template.save(employee);        
        return employee;
	}
	@Override
	public Employee updateEmployeeName(int id, String name) {
		Employee employee=null;
		employee = template.get(Employee.class, id);
        employee.setName(name);
        template.save(employee);
        return employee;
	}

	@Override
	public Employee fetchEmployee(int id) {
		return template.get(Employee.class, id);
	}

	@Override
	public List<Employee> fetchEmployees() {
		return template.loadAll(Employee.class);
	}
	@Override
	public List<Employee> getEmployees() {
		return employeeDao.fetchEmployees();
	}
	@Override
	public List<Employee> getEmployeesOrderByName() {
		
		List<Employee> emplist = getEmployees();
		Collections.sort(emplist, new Comparator<Employee>() {
			public int compare (Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});
		//sorting using lambda expression
		emplist.sort((Employee e1, Employee e2)-> e1.getName().compareTo( e2.getName()));
		return emplist;

	}

}