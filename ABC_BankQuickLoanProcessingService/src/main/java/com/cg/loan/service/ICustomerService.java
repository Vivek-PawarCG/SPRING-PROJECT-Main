package com.cg.loan.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.loan.model.Customer;
import com.cg.loan.exception.CustomerNotFoundException;

/*Customer Service
 * ICustomerServiceImpl implements the interface ICustomerService
 * Customer addCustomer(Customer customer) to add new customer to table
 * Customer updateCustomer(Customer customer) throws CustomerNotFoundException to update customer details
 * Customer deleteCustomer(int custid) throws CustomerNotFoundException to delete customer using Id
 * Customer viewCustomer(int custid) throws CustomerNotFoundException view customer by Id
 * List<Customer> viewAllCustomers() to view all the customers in the table
 * List<Customer> viewCustomerList(LocalDate dateOfApplication) view customer details having loan agreement as per loan application date
 * 

 * */



public interface ICustomerService  {
	
	public Customer addCustomer(Customer customer) ;
	public Customer updateCustomer(Customer customer)throws CustomerNotFoundException;
	public Customer deleteCustomer(int custid) throws CustomerNotFoundException;
	public Customer viewCustomer(int custid) throws CustomerNotFoundException;
	public List<Customer> viewAllCustomers();
//   public List<Customer> viewCustomerList(LocalDate dateOfApplication);


}


