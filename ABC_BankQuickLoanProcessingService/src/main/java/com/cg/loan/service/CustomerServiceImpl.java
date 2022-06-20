package com.cg.loan.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loan.model.Customer;

import com.cg.loan.exception.CustomerNotFoundException;
import com.cg.loan.repository.ICustomerRepository;

import com.cg.loan.repository.ILoanApplicationRepository;
import com.cg.loan.service.CustomerServiceImpl;

//Customer Service
//CustomerServiceImpl implements the interface ICustomerService

@Service
public class CustomerServiceImpl implements ICustomerService { 
	//The implements keyword is used to implement an interface
	Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());

	@Autowired
	ICustomerRepository repository;

	@Autowired
	ILoanApplicationRepository applicationRepository;

	public CustomerServiceImpl(ICustomerRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional //when you want the certain method/class(=all methods inside) to be executed in a transaction
	@Override
	//Customer addCustomer(Customer customer) to add new customer to table
	public Customer addCustomer(Customer customer) {

		try {
			repository.save(customer);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return customer;
	}

	@Transactional
	@Override
	//Customer updateCustomer(Customer customer) throws CustomerNotFoundException to update customer details
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {

		Optional<Customer> optional = repository.findById(customer.getUserId());
		if (optional.isPresent()) {
			repository.save(customer);
			return optional.get();
		} else {
			throw new CustomerNotFoundException("Customer couldn't be Updated! ");
		}

	}

	@Transactional
	@Override
	//Customer deleteCustomer(int custid) throws CustomerNotFoundException to delete customer using Id
	public Customer deleteCustomer(int custid) throws CustomerNotFoundException {

		Optional<Customer> optional = repository.findById(custid);
		if (optional.isPresent()) {
			repository.deleteById(custid);
			return optional.get();
		} else {
			throw new CustomerNotFoundException("Customer not found for delete operation!");
		}

	}

	@Override
	//Customer viewCustomer(int custid) throws CustomerNotFoundException view customer by Id
	public Customer viewCustomer(int custid) throws CustomerNotFoundException {

		Optional<Customer> optional = repository.findById(custid);
		try {

			if (optional.isPresent()) {
				repository.findById(custid);
			} else {
				throw new CustomerNotFoundException("Customer not found with the matching ID!");
			}

		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new CustomerNotFoundException("Customer not found with the matching ID!");
		}
		return optional.get();
	}

	@Override
	//List<Customer> viewAllCustomers() to view all the customers in the table
	public List<Customer> viewAllCustomers() {
		List<Customer> customerList = null;
		try {
			customerList = repository.findAll();
		} catch (Exception e) {
			logger.info(e.getMessage());

		}

		return customerList;
	}
}