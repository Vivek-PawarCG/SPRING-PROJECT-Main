package com.cg.loan.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.cg.loan.model.Customer;
import com.cg.loan.model.LoanApplication;
import com.cg.loan.model.Status;

import io.swagger.annotations.ApiModelProperty;

@Entity

public class LoanApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_gen")
	private long applicationId;

	@Column
	@FutureOrPresent //Date should be present or future 
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate applicationDate;

	//	new mapping:  loan application mapped with user_id
	@OneToOne
	@JoinColumn(name = "user_Info", referencedColumnName = "userId")
	private Customer customer;
	
	//	new mapping:  loan application mapped with loan program id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="loan_id")
	private Loan loan;

	@Column
	@DecimalMin(value = "0", message = "Loan applied amount should not be less than thousand values")
	private double loanAppliedAmount;

	@Column
	@DecimalMin(value = "0", message = "Loan approved amount should not be less than thousand values")
	private double loanApprovedAmount;

	@Column
	private boolean loanStatusApproval;

	@Column
	private boolean adminApproval;

	@Column
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public LoanApplication() {
		super();

	}

	public LoanApplication(long applicationId, LocalDate applicationDate, Customer customer, double loanAppliedAmount,
			double loanApprovedAmount, boolean loanStatusApproval, boolean adminApproval, Status status) {
		super();
		this.applicationId = applicationId;
		this.applicationDate = applicationDate;
		this.customer = customer;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.loanStatusApproval = loanStatusApproval;
		this.adminApproval = adminApproval;
		this.status = status;
	}
	
	
	public LoanApplication(long applicationId, Status status) {
		super();
		this.applicationId = applicationId;
		this.status = status;
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}

	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}

	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}

	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}

	public boolean isLoanStatusApproval() {
		return loanStatusApproval;
	}

	public void setLoanStatusApproval(boolean loanStatusApproval) {
		this.loanStatusApproval = loanStatusApproval;
	}

	public boolean isAdminApproval() {
		return adminApproval;
	}

	public void setAdminApproval(boolean adminApproval) {
		this.adminApproval = adminApproval;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (applicationId ^ (applicationId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanApplication other = (LoanApplication) obj;
		if (applicationId != other.applicationId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoanApplication [applicationId=" + applicationId + ", applicationDate=" + applicationDate
				+ ", customer=" + customer + ", loanAppliedAmount=" + loanAppliedAmount + ", loanApprovedAmount="
				+ loanApprovedAmount + " =" + loanStatusApproval + ", adminApproval=" + adminApproval
				+ ", status=" + status + "]";
	}

}
