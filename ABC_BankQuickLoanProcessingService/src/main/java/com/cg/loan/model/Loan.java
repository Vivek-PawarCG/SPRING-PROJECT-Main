package com.cg.loan.model;

import java.io.Serializable; 


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "loan_program")

public class Loan implements Serializable {

	@Id
	@Column(name = "loan_id")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_gen")
	@SequenceGenerator(name = "loan_gen", sequenceName = "loan_id_seq")
	private int loanId;
	
	@Column(name = "loan_type")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_gen")
	private String loanType;
	
	@Column(name = "loan_tenure")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_gen")
	private int loanTenure;
	
	@Column(name = "loan_amount")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_gen")
	private int loanAmount;
	
//	@Column(name = "loan_emi")
//	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_gen")
//	private int loanEmi;
	
	@Column(name = "loan_interest")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_gen")
	private Double loanInterest;

	/*
	 * public Loan addLoan;
	 * 
	 * public Loan getAddLoan() { return addLoan; }
	 * 
	 * public void setAddLoan(Loan addLoan) { this.addLoan = addLoan; }
	 */

	
	
	
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

//	public int getLoanEmi() {
//		return loanEmi;
//	}
//
//	public void setLoanEmi(int loanEmi) {
//		this.loanEmi = loanEmi;
//	}

	public Double getLoanInterest() {
		return loanInterest;
	}

	public void setLoanInterest(Double loanInterest) {
		this.loanInterest = loanInterest;
	}

	/*
	 * public void add(Loan loan) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	
	
}