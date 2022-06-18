package com.cg.loan.service;

import java.util.List;


import com.cg.loan.model.Loan;

public interface ILoanServices {

	List<Loan> getLoanList(); 

	public String addLoan(Loan loan);

	List<Loan> findAll();

	void save(Loan loan);

	void saveAndFlush(Loan loan);

	void deleteById(int loanId);

}
