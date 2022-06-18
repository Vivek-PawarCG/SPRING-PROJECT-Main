package com.cg.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import com.cg.loan.model.Loan;
//import com.cg.loan.service.LoanServices;
import com.cg.loan.service.ILoanServices;
import com.cg.loan.service.LoanServices;

@Component
@RestController
@RequestMapping(value = "/admin")

public class AdminServiceController {


	@Autowired
	LoanServices Service;
	
	 
	@RequestMapping(path="/getLoan")
	public List<Loan> getFrame(){
		List<Loan> loanList=Service.getLoan();
		return loanList;
	}

	@PostMapping(value = "/addLoan", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Loan> addFrame(@RequestBody Loan loan) { 
		List<Loan> id = Service.addLoan(loan);
		System.out.println("add loan in database");
		return ResponseEntity.ok(loan);
	}
	
	@PutMapping("/editLoan")
	public ResponseEntity<List<Loan>> updateFrame(@RequestBody Loan loan){
		System.out.println(loan);
		List<Loan> loan1= Service.updateLoan(loan);
		System.out.println("update loan in database");
		return new ResponseEntity<List<Loan>>(loan1, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "{loanId}", produces = "application/json")
	public ResponseEntity<List<Loan>> deleteEmployee(@PathVariable("loanId") int loanId) {
		List<Loan> loan= Service.deleteLoan(loanId);
		System.out.println("delete loan in database");
		return new ResponseEntity<List<Loan>>(loan, HttpStatus.OK);
		

	}
	
	
}
