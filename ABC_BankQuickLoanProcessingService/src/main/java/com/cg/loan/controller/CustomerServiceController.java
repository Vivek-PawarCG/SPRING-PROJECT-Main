package com.cg.loan.controller;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loan.controller.CustomerServiceController;
import com.cg.loan.model.Customer;
import com.cg.loan.exception.CustomerNotFoundException;
import com.cg.loan.service.ICustomerService;


@Validated //it automatically validates the argument
@RestController
@RequestMapping("/customer")

public class CustomerServiceController {
	Logger logger = Logger.getLogger(CustomerServiceController.class.getName());
	@Autowired
	private ICustomerService customerService;
	
	//A Logger object is used to log messages for a specific system or application component

	public CustomerServiceController() {
		logger.log(Level.INFO, "-----> Customer Rest Controller Working!");

	}

	//Application home page
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome to ABC bank Quick loan processing service ";
	}

	//Add new Customer Details
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody @Valid Customer customer) {
		this.customerService.addCustomer(customer);
		return customer;
	}

	//View customer details by id
	@GetMapping("/view/{custid}")
	public Customer viewCustomer(@PathVariable("custid") int custid) throws CustomerNotFoundException {
		return this.customerService.viewCustomer(custid);

	}

	//Update customer details
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody @Valid Customer customer) throws CustomerNotFoundException {
		return this.customerService.updateCustomer(customer);

	}

	//Delete Customer Details
	@DeleteMapping("/delete/{custid}")
	public Customer deleteCustomer(@PathVariable("custid") int custid) throws CustomerNotFoundException {
		return this.customerService.deleteCustomer(custid);

	}

	//View all customers
	@GetMapping("/viewall")
	public List<Customer> viewAllCustomers() {
		return this.customerService.viewAllCustomers();

	}

}
