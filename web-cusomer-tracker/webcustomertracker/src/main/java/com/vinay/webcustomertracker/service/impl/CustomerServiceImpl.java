package com.vinay.webcustomertracker.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.webcustomertracker.dao.CustomerDAO;
import com.vinay.webcustomertracker.entity.Customer;
import com.vinay.webcustomertracker.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

//	need to inject customer dao
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer saveCustomer(Customer customer) {
		return customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deletCustomer(id);
	}

}
