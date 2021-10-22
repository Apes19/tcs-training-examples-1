package com.tcs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestStoreEmployee {
	public static void main(String[] args) {
		// Some codes must be written in DAO layer
		// 1st step is configure hiberaten.cfg.xml
		Configuration cfg = new Configuration().configure(); // by default it uses hibernate.cfg.xml
		// configure("someOther.xml") is used if the xml file name is different
		// 2nd step is to create session factory that creates database connection
		SessionFactory factory = cfg.buildSessionFactory();
		// 3rd step is to create Session to perform CRUD operations
		Session session = factory.openSession();
		Employee employee1 = new Employee();
		employee1.setName("Alex");
		employee1.setSalary(45200);
		
		Employee employee2 = new Employee();
		employee2.setName("Bruce");
		employee2.setSalary(88200);
		// 4th step create transaction to perform store
		Transaction transaction = session.beginTransaction();
		// 5th step is to perfrom store 
		session.save(employee1); // stores the employee1 to the Employee
		session.save(employee2); // stores the employee2 to the Employee table
		// commit the changes using transaction.commit()
		transaction.commit();
		
		// last step is to close Session & SessionFactory
		session.close();
		factory.close();
		System.out.println("---- Saved Successfully -----");
	}

}
