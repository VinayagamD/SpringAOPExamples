package com.vinay.webcustomertrackeraop.dao;

import java.util.List;

import com.vinay.webcustomertrackeraop.entity.Customer;

public interface CustomerDAO {
	
	List<Customer> getCustomers();

	Customer saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deletCustomer(int id);

}
