package com.cg.loan.model;

import java.io.Serializable; 


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial") //instruct the compiler to ignore or suppress, specified compiler warning in annotated element and all program elements inside that element.
@Entity
@Table(name = "loan_program") //Adds Table in database

public class Loan implements Serializable {

	@Id
	@Column(name = "loan_id") //Indicates database table columns
	@SequenceGenerator(name = "loan_gen", sequenceName = "loan_id_seq") 
	//defines a primary key generator that may be referenced by name when a generator element is specified for the GeneratedValue annotation
	private int loanId;
	
	@Column(name = "loan_type")
	private String loanType;
	
	@Column(name = "loan_tenure")
	private int loanTenure;
	
	@Column(name = "loan_amount")
	private int loanAmount;
	
	@Column(name = "loan_interest")
	private Double loanInterest;

	public Loan(){
		   super();
		}
	
	public Loan(int loanId, String loanType, int loanTenure, int loanAmount, Double loanInterest) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.loanTenure = loanTenure;
		this.loanAmount = loanAmount;
		this.loanInterest = loanInterest;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getLoanInterest() {
		return loanInterest;
	}

	public void setLoanInterest(Double loanInterest) {
		this.loanInterest = loanInterest;
	}


}