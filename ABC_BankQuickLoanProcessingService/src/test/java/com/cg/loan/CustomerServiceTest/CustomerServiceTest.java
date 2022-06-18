package com.cg.loan.CustomerServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.loan.exception.CustomerNotFoundException;
import com.cg.loan.model.Customer;
import com.cg.loan.repository.ICustomerRepository;
import com.cg.loan.repository.ILoanApplicationRepository;
import com.cg.loan.service.CustomerServiceImpl;

/* Customer Service Junit Testing
 * Testing add new customer by passing all the required parameters
 * Testing view all customers by passing all the required parameters
 * Testing view customer by customer Id by passing all the required parameters
 * Testing delete customer by customer Id by passing all the required parameters
 * Testing update customer details by passing all the required parameters
 * 

 * */

@SpringBootTest
class CustomerServiceTest {
	@Autowired
	private CustomerServiceImpl customerService;
	
	@MockBean
	ICustomerRepository customerRepo;
	ILoanApplicationRepository applicationRepo;
	
	@Test
	public void testSaveCustomer() {
		Customer customerInput=new Customer(1, "Vishal","9876543210","vishal@gmail.com","vishal123", "customer", LocalDate.of(2022, 6, 10),"Male","Indian","1231231223","1234ytioui");
		when(customerRepo.save(customerInput)).thenReturn(customerInput);
		Customer customer_test = customerService.addCustomer(customerInput);
		assertEquals(customerInput, customer_test);
	}
	
	@Test
	void testDeleteCustomer() throws CustomerNotFoundException {
		Customer customerInput = new Customer(2, "Vishal","9876543210","vishal@gmail.com","vishal123", "customer", LocalDate.of(2022, 6, 10),"Male","Indian","1231231223","1234ytioui");
		
		Customer customer_delete = new Customer(2, "Vishal","9876543210","vishal@gmail.com","vishal123", "customer", LocalDate.of(2022, 6, 10),"Male","Indian","1231231223","1234ytioui");
		try {
			doNothing().when(customerRepo).delete(customerInput);

			customerService.deleteCustomer(1);

			verify(customerRepo).delete(customerInput);
			assertEquals(customerInput, customer_delete);

		} catch (CustomerNotFoundException e) {

		}
		
	}
	
	@Test
	void testUpdateCustomer() throws CustomerNotFoundException {

		Customer customerInput = new Customer(1, "Vishal","9876543210","vishal@gmail.com","vishal123", "customer", LocalDate.of(2022, 6, 10),"Male","Indian","1231231223","1234ytioui");
		Optional<Customer> optionalCustomer = Optional.of(customerInput);
		Customer updateCustomer = new Customer(1, "Vishal","9876543210","vishal123@gmail.com","vishal123", "customer", LocalDate.of(2022, 6, 10),"Male","Indian","1231231223","1234ytioui");
		when(customerRepo.findById(1)).thenReturn(optionalCustomer);
		when(customerRepo.save(updateCustomer)).thenReturn(updateCustomer);
		Customer customer_test = customerService.updateCustomer(updateCustomer);
		assertEquals(updateCustomer, customer_test);

	}
	@Test
	void testGetAllCustomers() {
		@SuppressWarnings("unchecked")
		List<Customer> customerList = mock(List.class);
		when(customerRepo.findAll()).thenReturn(customerList);
		List<Customer> outputCustomerList = customerService.viewAllCustomers();
		assertEquals(customerList, outputCustomerList);
	}

	@Test
	void testViewCustomerById() throws CustomerNotFoundException {

		int input = 1;
		Customer customer = mock(Customer.class);
		Optional<Customer> optional_customer = Optional.of(customer);
		when(customerRepo.findById(input)).thenReturn(optional_customer);
		Optional<Customer> customer_test = Optional.of(customerService.viewCustomer(input));
		assertEquals(optional_customer, customer_test);
	}
	
	
	
	
	


}

