package com.cg.loan.exception;

@SuppressWarnings("serial")
public class LoanNotFoundException extends Exception{
	
	//Executes a message if customer with given id not found
		public LoanNotFoundException(String message) {
			super(message);
			

		}

}
