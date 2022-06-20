package com.cg.loan.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.loan.model.Admin;
import com.cg.loan.model.LoanApprovalDepartment;

import com.cg.loan.service.IUserService;


@Validated
@RestController
@RequestMapping("/user")

public class UserServiceController {

	@Autowired
	IUserService userService;
	
	//Add Admin as User
	@PostMapping("/addAdmin")
	public Admin addNewUser(@RequestBody  @Valid Admin admin) {
		this.userService.addNewUser(admin);
		return admin;
		
	}
	
	//Add LAD officer as User
	@PostMapping("/addLADofficer")
	public LoanApprovalDepartment addNewUser(@RequestBody  @Valid LoanApprovalDepartment loanapprovaldepartment) {
		this.userService.addNewUser(loanapprovaldepartment);
		return loanapprovaldepartment;
		
	}
	
	
}


