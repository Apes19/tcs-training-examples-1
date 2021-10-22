package com.tcs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// spring creates the object in the container with the name customerDaoImplV1
@Repository
public class CustomerDaoImplV1 implements CustomerDao {
	// the datasource object is injected to this property
	@Autowired
	private Datasource datasource;
	public void connect() {
		System.out.println("connect() in CustomerDaoImplV1");
		System.out.println("Url: "+datasource.getUrl());
		System.out.println("Username: "+datasource.getUsername());
		System.out.println("Password: "+datasource.getPassword());
	}
	@Override
	public void store() {
		connect();
		System.out.println("store() in CustomerDaoImplV1");
	}

	@Override
	public void update() {
		connect();
		System.out.println("update() in CustomerDaoImplV1");
	}

}
