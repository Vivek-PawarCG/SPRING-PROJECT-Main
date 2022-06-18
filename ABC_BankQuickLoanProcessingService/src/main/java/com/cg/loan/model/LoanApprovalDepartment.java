package com.cg.loan.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cg.loan.model.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@DiscriminatorValue(value = "4")
public class LoanApprovalDepartment extends User {

	@NotEmpty(message = "Loan Approval Officer Name can't be empty!")
	@Size(min = 3, max = 25, message = "Invalid Loan Approval Officer Name please enter a vaild Name!")
	@Pattern(regexp = "^[A-Za-z]+", message = "INVALID PLEASE ENTER AGAIN")
	private String loanOfficerName;

	@NotEmpty(message = "Phone Number can't be empty!")
	@Size(min = 10, max = 10, message = "Invalid Phone Number please enter a vaild phone number of minimum 10 digits")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid input:Enter numbers only")
	private String loanOfficerContact;

	@Override
	public int hashCode() {
	
		return super.hashCode();
	}

	@Override
	public boolean equals(Object objects) {
	
		return super.equals(objects);
	}

	public LoanApprovalDepartment() {
		super();

	}

	public LoanApprovalDepartment(int userId, String password, String role) {
		super(userId, password, role);

	}

	public LoanApprovalDepartment(int userId) {
		super(userId);

	}

	public LoanApprovalDepartment(String loanOfficerName, String loanOfficerContact) {
		super();
		this.loanOfficerName = loanOfficerName;
		this.loanOfficerContact = loanOfficerContact;
	}

	public String getloanOfficerName() {
		return loanOfficerName;
	}

	public void setloanOfficerName(String loanOfficerName) {
		this.loanOfficerName = loanOfficerName;
	}

	public String getloanOfficerContact() {
		return loanOfficerContact;
	}

	public void setloanOfficerContact(String loanOfficerContact) {
		this.loanOfficerContact = loanOfficerContact;
	}

	@Override
	public String toString() {
		return "LoanApprovalDepartment [loanOfficerName=" + loanOfficerName + ", loanOfficerContact="
				+ loanOfficerContact + "]";
	}

}
