package com.cg.loan.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loan.model.LoanApplication;
import com.cg.loan.exception.InvalidLoanApplicationException;
import com.cg.loan.service.ILoanApprovalDepartmentService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;


@Validated
@RestController
@RequestMapping("/verify")
public class LoanApprovalDepartmentController {
	Logger logger = Logger.getLogger(LoanApprovalDepartmentController.class.getName());
	@Autowired
	private ILoanApprovalDepartmentService service;

	// Method to check the working of rest controller in the console
	public LoanApprovalDepartmentController() {
		logger.log(Level.INFO, "-----> LAD Rest Controller Working!");

	}

	// Method to check the connection with the webservice
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : Home Loan Application (Version 1.0)"; // returns String value
	}

	
	@PutMapping("/status")
	// Method to update the status of application and loan amount if approved,
	// passes the parameters of application class
	public LoanApplication updateStatus(@RequestBody @Valid LoanApplication loanapplication)
			throws InvalidLoanApplicationException {

		return this.service.updateStatus(loanapplication); // returns the updated loan application
	}

}
