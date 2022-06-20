package com.cg.loan.exception;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends Exception {

    //Executes a message if customer with given id not found
	public CustomerNotFoundException(String message) {
		super(message);

	}


}
