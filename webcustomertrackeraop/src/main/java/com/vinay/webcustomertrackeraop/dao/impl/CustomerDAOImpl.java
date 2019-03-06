package com.vinay.webcustomertrackeraop.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vinay.webcustomertrackeraop.dao.CustomerDAO;
import com.vinay.webcustomertrackeraop.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

//	need to inject the session Factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
//		get the current hibernate session
		Session session=  sessionFactory.getCurrentSession();
//		create  a query ... sort by  last name
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
//		execute the query and get result list
		List<Customer> customers = query.getResultList();
//		return the results
		return customers;
	}


	@Override
	public Customer saveCustomer(Customer customer) {
//		get current hibernate session
		Session session = sessionFactory.getCurrentSession();
//		save the customer... finally LOL
		session.saveOrUpdate(customer);
		return customer;
	}


	@Override
	public Customer getCustomer(int id) {
//		get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
//		now retrieve/read from database using the primary key
		Customer customer = session.get(Customer.class, id);
		return customer;
	}


	@Override
	public void deletCustomer(int id) {
//		get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
//		delete the object with primary key
		Query query = session.createQuery("DELETE FROM Customer WHERE id=:customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
		
	}
	
	

}
