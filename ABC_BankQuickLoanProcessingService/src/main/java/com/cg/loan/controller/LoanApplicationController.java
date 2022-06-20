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

import com.cg.loan.controller.LoanApplicationController;
import com.cg.loan.model.Loan;
import com.cg.loan.model.LoanApplication;
import com.cg.loan.exception.InvalidLoanApplicationException;
import com.cg.loan.service.ILoanApplicationService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/loanapplication")

public class LoanApplicationController {

	Logger logger = Logger.getLogger(LoanApplicationController.class.getName());

	public LoanApplicationController() {
		logger.log(Level.INFO, "----->Inside Loan Application Controller Working!");

	}

	@Autowired
	ILoanApplicationService loanApplicationService;

	//home" is to check the home page
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : Home Loan Application (Version 1.0)";
	}

	//add" is to add new loan application connected to a customer in the database
	@PostMapping("/add")
	public LoanApplication addLoanApplication(@RequestBody @Valid LoanApplication loanApplication) {
		this.loanApplicationService.addLoanApplication(loanApplication);
		return loanApplication;
	}

	//update" to update the application details or make any specific changes to details
	@PutMapping("/update")
	public LoanApplication updateLoanApplication(@RequestBody @Valid LoanApplication loanApplication)
			throws InvalidLoanApplicationException {
		this.loanApplicationService.updateLoanApplication(loanApplication);
		return loanApplication;
	}

	//delete/{loan_id}" to delete the application from the database using the loan_id
	@DeleteMapping("/delete/{applicationid}")
	public LoanApplication deleteLoanApplication(@PathVariable("applicationid") long loanApplicationId)
			throws InvalidLoanApplicationException {
		return this.loanApplicationService.deleteLoanApplication(loanApplicationId);

	}

	//viewallloan" to viewall the loan applications available in the database
	@GetMapping("/viewallloan")
	public List<LoanApplication> retrieveAllLoanApplication() {
		return this.loanApplicationService.retrieveAllLoanApplication();

	}

	//viewbyid/{loan_id}" is to view the application details by using the loan ID
	@GetMapping("/viewbyid/{loanid}")
	public LoanApplication retrieveLoanApplicationById(@PathVariable("loanid") long loanApplicationId)
			throws InvalidLoanApplicationException {
		return this.loanApplicationService.retrieveLoanApplicationById(loanApplicationId);

	}

}
