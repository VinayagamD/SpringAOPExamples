package com.vinay.webcustomertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vinay.webcustomertracker.entity.Customer;
import com.vinay.webcustomertracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//	new to inject our customer service
	@Autowired
	private  CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
//		get the customer from the service
		List<Customer> customers =  customerService.getCustomers();
//		add the customer to the model
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
//		create model attribute to bind form 	data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
//		delete the  customer
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
//		save the customer using our service
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
//		get the customer from the database
		Customer customer = customerService.getCustomer(id);
//		set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
//		send over to  our form
		
		
		return "customer-form";
		
	}
}