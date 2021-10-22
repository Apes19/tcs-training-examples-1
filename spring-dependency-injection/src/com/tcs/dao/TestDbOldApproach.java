package com.tcs.dao;

/*
 * Assume this is service layer depends on the DAO
 */
public class TestDbOldApproach {

	public static void main(String[] args) {
		Datasource ds = new Datasource();
		ds.setUrl("jdbc:mysql://ip:port");
		ds.setUsername("admin");
		ds.setPassword("admin123");
		CustomerDao dao = new CustomerDao();
		dao.setDatasource(ds);
		dao.connect();
	}

}
