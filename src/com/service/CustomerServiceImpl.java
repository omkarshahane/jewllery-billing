package com.service;

import com.Customer;
import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {
	
	CustomerDao cdao = new CustomerDaoImpl();

	public CustomerServiceImpl() {
		
	}

	public Customer addNewCustomer(String cname, String mobile, String address) {
		// TODO Auto-generated method stub
		return cdao.addNewCustomer(cname, mobile, address) ;
		
	}
	
	
	

}
