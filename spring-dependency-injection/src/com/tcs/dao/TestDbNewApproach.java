package com.tcs.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Assume this is a Service Layer code this depends on the CustomerDao
 */
public class TestDbNewApproach {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		CustomerDao dao = (CustomerDao)context.getBean("dao");
		dao.connect();
		((ClassPathXmlApplicationContext)context).close();
	}
}
