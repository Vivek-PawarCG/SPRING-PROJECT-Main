package com.cg.loan.exception;

@SuppressWarnings("serial")
public class InvalidLoanApplicationException extends Exception {

	//Executes a message if Loan application with given id not found
	public InvalidLoanApplicationException(String message) {
		super(message);


}
}
