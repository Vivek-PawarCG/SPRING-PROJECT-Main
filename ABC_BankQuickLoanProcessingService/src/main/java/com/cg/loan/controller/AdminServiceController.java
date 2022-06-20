package com.cg.loan.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.loan.exception.LoanNotFoundException;
import com.cg.loan.model.Loan;
import com.cg.loan.service.LoanServicesImpl;

@Component        //allows Spring to automatically detect our custom beans
@RestController  //allows to handle all REST APIs such as GET, POST, Delete, PUT requests
@RequestMapping(value = "/loans") //to map web requests onto specific handler classes and/or handler methods.

public class AdminServiceController {


	
	@Autowired  //is used to auto-wire a bean into another bean
	LoanServicesImpl Service;
	
	 
	@PostMapping("/admin/add")
	public Loan addLoan(@RequestBody Loan loan) {
		this.Service.addLoan(loan);
		return loan;
	}

	//View Loan details by id
	@GetMapping("/view/{loanid}")
	public Loan viewLoan(@PathVariable("loanid") int loanid) throws LoanNotFoundException {
		return this.Service.viewLoan(loanid);

	}

	//Update Loan details
	@PutMapping("/admin/update")
	public Loan updateLoan(@RequestBody Loan loan) throws LoanNotFoundException {
		return this.Service.updateLoan(loan);

	}

	//Delete Loan Details
	@DeleteMapping("/admin/delete/{loanid}")
	public Loan deleteLoan(@PathVariable("loanid") int loanid) throws LoanNotFoundException {
		return this.Service.deleteLoan(loanid);

	}

	//View all Loan Programs
	@GetMapping("/viewall")
	public List<Loan> viewAllLoans() {
		List<Loan> loanList=Service.viewAllLoans();
		return loanList;

	}
	
	
}
