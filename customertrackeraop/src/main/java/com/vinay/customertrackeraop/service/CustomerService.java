package com.vinay.customertrackeraop.service;

import java.util.List;

import com.vinay.customertrackeraop.entity.Customer;

public interface CustomerService {
	List<Customer> getCustomers();

	Customer saveCustomer(Customer customer);

	Customer getCustomer(int id);

	void deleteCustomer(int id);
}
