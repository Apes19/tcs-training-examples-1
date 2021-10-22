package com.tcs.dao;

public class CustomerDao {
	private Datasource datasource;

	public Datasource getDatasource() {
		return datasource;
	}

	public void setDatasource(Datasource datasource) {
		this.datasource = datasource;
	}
	/*
	 * right now we are not connecting to any real database
	 */
	public void connect() {
		System.out.println("---- connecting to database ----");
		System.out.println("URL: "+datasource.getUrl());
		System.out.println("Username: "+datasource.getUsername());
		System.out.println("Password:"+datasource.getPassword());
	}
}
