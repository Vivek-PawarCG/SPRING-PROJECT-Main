package com.cg.loan.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import com.cg.loan.d.ILoanRepository;
import com.cg.loan.model.Loan;
import com.cg.loan.repository.ILoanRepository;
@Service
public class LoanServices{
	
	@Autowired
	ILoanRepository loanDao;
	
	public List<Loan> getLoan() {
		return loanDao.findAll();
		 }
	public  List<Loan> addLoan(Loan loan) {
		 loanDao.save(loan);
		 return loanDao.findAll();
	}
	public List<Loan> updateLoan(Loan loan) {
		// TODO Auto-generated method stub
		 loanDao.saveAndFlush(loan);
		 return loanDao.findAll();
	}
	public List<Loan> deleteLoan(int loanId) {
		// TODO Auto-generated method stub
		 loanDao.deleteById(loanId); 
		 return loanDao.findAll();
	}
	
	/*public void setLoanDao(ILoanServices Lservice) {
		this.loanDao = Lservice;
	}


	@Transactional
	public String addLoan(Loan loan) {
		loan.add(loan);
		return "Loan Program Added";
		*/
	}
	/*
	 * @Override
	 * 
	 * @Transactional public List<Loan> addLoan(Loan loan) { return (List<Loan>)
	 * loanDao; }
	 */
