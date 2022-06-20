package com.cg.loan.controller;
	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.loan.model.Login;


@RestController
@RequestMapping(value = "/signin")

public class LoginController {
	
    //Login Page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage() {
		return "Welcome to ABC Bank login page";
	}
 
	//Admin Login
	@PostMapping(value = "/admin/login", consumes = "application/json", produces = "application/json")
	public String display(@RequestBody Login login) {
		// System.out.println("Please Login");
		System.out.println("userId" + login.userId);
		String myusername = "admin";
		String mypass = "admin123";
		if (login.userId.equals(myusername) && login.password.equals(mypass)) {
			return "Welcome ADMIN to ABC Bank Quick Loan Application";
		} else {
			return "Admin Login failed, Please check the credentials ";
		}

	}
    //LAD Login
	@PostMapping(value = "/lad/login", consumes = "application/json", produces = "application/json")
	public String display1(@RequestBody Login login) {
		// System.out.println("Please Login");
		System.out.println("userId" + login.userId);
		String myusername = "ladadmin";
		String mypass = "pass123";
		if (login.userId.equals(myusername) && login.password.equals(mypass)) {
			return "Welcome to ABC Bank LOAN APPROVAL DEPT";
		} else {
			return "LAD Login failed, Please check the credentials ";
		}

	}
	//Logout from application
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage() {
		return "Successfully Logged Out";
	}

}
