package com.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.dao.CustomerDao;
// spring does component scan and creates object with the id customerServiceImplV1
@Service
public class CustomerServiceImplV1 implements CustomerService {
	// supplies the CustomerDao implementation
	@Autowired
	private CustomerDao dao;
	
	@Override
	public void save() {
		dao.store();
		System.out.println("save() inside CustomerServiceImplV1");
	}

	@Override
	public void update() {
		dao.update();
		System.out.println("update() inside CustomerServiceImplV1");
	}

}
