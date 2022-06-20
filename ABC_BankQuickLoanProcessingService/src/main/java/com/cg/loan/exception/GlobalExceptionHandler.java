package com.cg.loan.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //allows to handle exceptions across the whole application in one global handling component
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private String desc="Description";
	
	@Override //indicates that the child class method is over-writing its base class method
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
				
		Map<String, String> map = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String msg = error.getDefaultMessage();
			
			map.put(fieldName, msg);
		});
		
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
	//Customer Not Found Exception
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerException(CustomerNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to get a customer");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	//Customer Not Found Exception
		@ExceptionHandler(LoanNotFoundException.class)
		public ResponseEntity<String> handleLoanException(LoanNotFoundException ex) {
			HttpHeaders header = new HttpHeaders();
			header.add(desc, "Trying to get loan");

			return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
			
		}
		
	
	//Status Approval Exception
	@ExceptionHandler(LoanStatusApprovalException.class)
	public ResponseEntity<String> handleLoanStatusException(LoanStatusApprovalException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to get a Loan Approval Officer");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}
	//Invalid Loan Application Exception
	@ExceptionHandler(InvalidLoanApplicationException.class)
	public ResponseEntity<String> handleInvalidLoanApplicationException(InvalidLoanApplicationException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to get Loan Application");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
		
	}

}
