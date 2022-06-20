package com.cg.loan.service;

import java.util.List;


import com.cg.loan.exception.LoanNotFoundException;
import com.cg.loan.model.Loan;


//Loan Program Service interface

public interface ILoanServices {

	public Loan addLoan(Loan loan) ;
	public Loan updateLoan(Loan loan)throws LoanNotFoundException;
	public Loan deleteLoan(int loanid) throws LoanNotFoundException;
	public Loan viewLoan(int loanid) throws LoanNotFoundException;
	public List<Loan> viewAllLoans();

}
