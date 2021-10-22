package com.tcs.viewcontroller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tcs.service.CustomerService;
// assuming this as a controller we need 
public class TestViewController {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CustomerService service = (CustomerService)context.getBean("customerServiceImplV1");
		service.save();
		System.out.println("----------------------");
		service.update();
		((ClassPathXmlApplicationContext)context).close();
	}
}
