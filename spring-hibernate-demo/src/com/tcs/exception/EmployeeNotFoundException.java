package com.tcs.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception {
	public EmployeeNotFoundException(String error) {
		super(error);
	}
}
/*
 * if code uses throw new EmployeeNotFoundException("some message");
 * in the catch block you can read those messages using getMessage()
 * like printStackTracke(), you also have getMessage() in Exception 
 * class
 */
