package com.tcs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// entity class to perform ORM
@Entity
// @Table is used to specify the table name
@Table(name = "employee")
public class Employee {

	// each property of the entity are mapped to the columns, primary key column must use @Id
	@Column(name = "emp_id")
	@Id // @Id is predefined annotation to mark the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto generate the value for primary key
	private int id;
	
	@Column(name = "emp_name")
	private String name;
	
	@Column(name = "emp_salary")
	private double salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
