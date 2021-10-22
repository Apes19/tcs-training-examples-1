package com.tcs.interfaces;

public class TestImpl implements Test {

	@Override
	public void method1() {
		System.out.println("method1() part of TestImpl");
	}

	@Override
	public void method2() {
		System.out.println("method2() part of TestImpl");
	}
	// not mandatory to override default methods
	public void method4() {
		System.out.println("method4() is overriden in TestImpl");
	}
}
