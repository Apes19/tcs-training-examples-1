package com.tcs;

import java.util.List;
import java.util.Scanner;

public class EmployeeViewController {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// based on the menuOption we can call appropriate methods of EmployeeDaoImpl
		int menuOption = 0;
		// creating the EmployeeDaoImpl instance
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		do {
			System.out.println("Enter the options below:-");
			System.out.println("1: Store 2: Retrieve by id 3: Retrieve all 4: Update salary by id 5: Delete by id 6: Exit");
			menuOption = scan.nextInt();
			switch(menuOption) {
			case 1:
				Employee e = new Employee();
				System.out.println("Enter name");
				e.setName(scan.next()); // input provided at runtime initializes the name
				System.out.println("Enter salary");
				e.setSalary(scan.nextDouble()); // input provided at runtime initializes the salary
				int generatedKey = dao.store(e);
				System.out.println("Generated Key: "+generatedKey);
				break;
			case 2: 
				System.out.println("Enter id to search");
				Employee employee = dao.fetchEmployee(scan.nextInt());
				if(employee != null) {
					System.out.println("Employee found id: "+employee.getId()+", name: "+employee.getName()+", salary: "+employee.getSalary());
				} else {
					System.err.println("Sorry employee not found");
				}
				break;
			case 3: 
				List<Employee> employees = dao.fetchEmployees();
				for(Employee emp : employees) {
					System.out.println("Id = "+emp.getId()+", Name = "+emp.getName()+", Salary = "+emp.getSalary());
				}
				System.out.println("--------------------------------");
				break;
			case 4:
				System.out.println("Enter the employee id");
				int id=scan.nextInt();
				System.out.println("Enter the salary");
				double salary= scan.nextDouble();
				Employee emp = dao.updateEmployee(id,salary);
				if(emp != null) {
					System.out.println("salary updated");
				} else {
					System.err.println("employee not found");
				}
				break;
			case 5:
				System.out.println("Enter the employee id to delete");
				Employee emp1 = dao.deleteEmployee(scan.nextInt());
				if(emp1!=null) {
					System.out.println("Employee deleted");
				}
				else {
					System.err.println("employee not found");
				}
				break;
			}
		} while(menuOption != 6);
		System.out.println("Program Exits!");
		scan.close();
	}
}
