package com.cg.loan.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loan.model.Loan;
import com.cg.loan.model.LoanApplication;
import com.cg.loan.exception.InvalidLoanApplicationException;
import com.cg.loan.repository.ILoanApplicationRepository;
import com.cg.loan.service.ILoanApplicationService;
import com.cg.loan.service.LoanApplicationImpl;

//Loan Application Service
// ILoanApplicationServiceImpl implements ILoanApplicationService interface


@Service
public class LoanApplicationImpl implements ILoanApplicationService {
	Logger logger = Logger.getLogger(LoanApplicationImpl.class.getName());

	@Autowired
	ILoanApplicationRepository repository;

	public LoanApplicationImpl(ILoanApplicationRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional
	@Override
	//LoanApplication addLoanApplication(LoanApplication loanApplication) to add new loan application
	public LoanApplication addLoanApplication(LoanApplication loanApplication) {

		try {
			repository.save(loanApplication);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return loanApplication;
	}

	@Transactional
	@Override
	//LoanApplication updateLoanApplication(LoanApplication loanApplication) throws InvalidLoanApplicationException to update the loan application
	public LoanApplication updateLoanApplication(LoanApplication loanApplication)
			throws InvalidLoanApplicationException {

		Optional<LoanApplication> optional = repository.findById(loanApplication.getApplicationId());
		if (optional.isPresent()) {
			repository.save(loanApplication);
			return optional.get();
		} else {

			throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");
		}

	}

	@Transactional
	@Override
	//LoanApplication deleteLoanApplication(long loanApplicationId) throws InvalidLoanApplicationException to delete the loan application
	public LoanApplication deleteLoanApplication(long loanApplicationId) throws InvalidLoanApplicationException {

		Optional<LoanApplication> optional = repository.findById(loanApplicationId);
		if (optional.isPresent()) {
			repository.deleteById(loanApplicationId);
			return optional.get();
		} else {
			throw new InvalidLoanApplicationException("Loan application ID not found for delete operation!");
		}

	}

	@Override
	//List<LoanApplication> retrieveAllLoanApplication() to get all the loan applications
	public List<LoanApplication> retrieveAllLoanApplication() {

		List<LoanApplication> list = null;
		try {
			list = repository.findAll();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return list;
	}

	@Override
	//LoanApplication retrieveLoanApplicationById(long loanApplicationId) throws InvalidLoanApplicationException to get all the loan applications by loan Id
	public LoanApplication retrieveLoanApplicationById(long loanApplicationId) throws InvalidLoanApplicationException {

		Optional<LoanApplication> optional = repository.findById(loanApplicationId);
		if (optional.isPresent()) {
			repository.findById(loanApplicationId);
			return optional.get();
		} else {
			throw new InvalidLoanApplicationException("Loan application ID not found in records!");
		}

}

}