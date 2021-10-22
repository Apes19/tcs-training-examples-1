package com.tcs.identifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * Assuming this class is depending on ID instances
 */
public class TestUINewApproach {

	public static void main(String[] args) {
		/*
		 *  initializing the spring container to read 
		 *  the bean configuration file
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		ID id = (ID)context.getBean("i1");
		id.display();
		
		/*
		 * Closing the resource
		 */
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
