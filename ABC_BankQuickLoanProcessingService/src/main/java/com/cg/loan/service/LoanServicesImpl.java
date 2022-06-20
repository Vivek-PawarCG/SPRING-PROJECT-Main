package com.cg.loan.service;

//Loan Services

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.loan.exception.LoanNotFoundException;
import com.cg.loan.model.Loan;
import com.cg.loan.repository.ILoanRepository;
@Service
public class LoanServicesImpl implements ILoanServices{
	//The implements keyword is used to implement an interface
		Logger logger = Logger.getLogger(LoanServicesImpl.class.getName());
	
	@Autowired
	ILoanRepository loanRepo;
	
	//Get Loan Programs
	public LoanServicesImpl(ILoanRepository loanRepo){
		super();
		this.loanRepo = loanRepo;
	}

	//@Transactional//when you want the certain method/class(=all methods inside) to be executed in a transaction
	@Override
	//Customer addLoan(Loan loan) to add new loan program to table
	public Loan addLoan(Loan loan) {

		try {
			loanRepo.save(loan);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return loan;
	}

	@Transactional
	@Override
	//Customer updateCustomer(Customer customer) throws CustomerNotFoundException to update customer details
	public Loan updateLoan(Loan loan) throws LoanNotFoundException {

		Optional<Loan> optional = loanRepo.findById(loan.getLoanId());
		if (optional.isPresent()) {
			loanRepo.save(loan);
			return optional.get();
		} else {
			throw new LoanNotFoundException("Loan Program couldn't be Updated! ");
		}

	}

	@Transactional
	@Override
	//Customer deleteCustomer(int custid) throws CustomerNotFoundException to delete customer using Id
	public Loan deleteLoan(int loanid) throws LoanNotFoundException {

		Optional<Loan> optional = loanRepo.findById(loanid);
		if (optional.isPresent()) {
			loanRepo.deleteById(loanid);
			return optional.get();
		} else {
			throw new LoanNotFoundException("Loan Program not found for delete operation!");
		}

	}

	@Override
	//Customer viewCustomer(int loanid) throws CustomerNotFoundException view customer by Id
	public Loan viewLoan(int loanid) throws LoanNotFoundException {

		Optional<Loan> optional = loanRepo.findById(loanid);
		try {

			if (optional.isPresent()) {
				loanRepo.findById(loanid);
			} else {
				throw new LoanNotFoundException("Loan Program not found with the matching ID!");
			}

		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new LoanNotFoundException("Loan Program not found with the matching ID!");
		}
		return optional.get();
	}

	@Override
	//List<Loan> viewAllLoans() to view all the loan programs in the table
	public List<Loan> viewAllLoans() {
		List<Loan> loanList = null;
		try {
			loanList = loanRepo.findAll();
		} catch (Exception e) {
			logger.info(e.getMessage());

		}

		return loanList;
	}
	 
	
}