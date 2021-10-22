package com.tcs.datetime;

import java.time.LocalDate;

public class User {
	private String name;
	private LocalDate dob;
	public User(String name, LocalDate dob) {
		super();
		this.name = name;
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", dob=" + dob + "]";
	}
}
