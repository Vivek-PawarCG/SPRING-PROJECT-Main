package com.cg.loan.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loan.model.Loan;
import com.cg.loan.model.Login;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@RestController
@RequestMapping(value = "/signin")
public class LoginController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String loginPage() {
		return "Welcome to ABC Bank login page";
	}
	
	@PostMapping(value="/admin/login", consumes = "application/json", produces ="application/json")
	public String display(@RequestBody Login login){
		//System.out.println("Please Login");
	System.out.println("userId" + login.userId);
	String myusername="admin";
	String mypass="root";
	if(login.userId.equals(myusername) && login.password.equals(mypass)) {
		return "Welcome to ABC Bank";
	}else {
		return "Admin Login failed, Please check the credentials ";
	}
	
	}
	
	@PostMapping(value="/lad/login", consumes = "application/json", produces ="application/json")
	public String display1(@RequestBody Login login){
		//System.out.println("Please Login");
	System.out.println("userId" + login.userId);
	String myusername="ladadmin";
	String mypass="pass123";
	if(login.userId.equals(myusername) && login.password.equals(mypass)) {
		return "Welcome to ABC Bank";
	}else {
		return "LAD Login failed, Please check the credentials ";
	}
	
	}

}
