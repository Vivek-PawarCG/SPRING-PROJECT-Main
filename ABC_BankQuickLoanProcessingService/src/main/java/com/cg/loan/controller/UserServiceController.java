package com.cg.loan.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.loan.model.Admin;
import com.cg.loan.model.LoanApprovalDepartment;

import com.cg.loan.model.User;
import com.cg.loan.service.IUserService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;


@Validated
@RestController
@RequestMapping("/user")

public class UserServiceController {

	@Autowired
	IUserService userService;
	
	
	@PostMapping("/addAdmin")
	public Admin addNewUser(@RequestBody  @Valid Admin admin) {
		this.userService.addNewUser(admin);
		return admin;
		
	}
	

	@PostMapping("/addLADofficer")
	public LoanApprovalDepartment addNewUser(@RequestBody  @Valid LoanApprovalDepartment loanapprovaldepartment) {
		this.userService.addNewUser(loanapprovaldepartment);
		return loanapprovaldepartment;
		
	}
	
	
	@PostMapping("/signin")
	public User signIn(@RequestBody  @Valid User user) {
		this.userService.signIn(user);
		return user;
		
	}

	
	@PostMapping("/signout")
	public User signOut(@RequestBody  @Valid User user) {
		this.userService.signOut(user);
		return user;
		
	}
}


