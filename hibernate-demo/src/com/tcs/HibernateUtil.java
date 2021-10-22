
package com.tcs;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// reusable class to use SessionFactory
public class HibernateUtil {
	public static SessionFactory createSessionFactory() {
		Configuration cfg = new Configuration().configure(); // by default it uses hibernate.cfg.xml
		// configure("someOther.xml") is used if the xml file name is different
		// 2nd step is to create session factory that creates database connection
		SessionFactory factory = cfg.buildSessionFactory();
		return factory;
	}
}
