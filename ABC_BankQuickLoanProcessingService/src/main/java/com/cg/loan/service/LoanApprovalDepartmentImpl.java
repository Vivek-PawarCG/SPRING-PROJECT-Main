package com.cg.loan.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loan.model.LoanApplication;
import com.cg.loan.exception.InvalidLoanApplicationException;
import com.cg.loan.repository.ILoanApplicationRepository;
//LoanApprovalDepartmentImpl implementation
@Service
public class LoanApprovalDepartmentImpl implements ILoanApprovalDepartmentService {

	@Autowired
	ILoanApplicationRepository ApplicationRepository;

	public LoanApprovalDepartmentImpl(ILoanApplicationRepository applicationRepository) {
		super();
		this.ApplicationRepository = applicationRepository;
	}

	@Override
	@Transactional
	// method to check loan application is present in the DB, 
	//update if application is present else invoke Exception class
	public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException {

		Optional<LoanApplication> optional = ApplicationRepository.findById(loanApplication.getApplicationId());
		if (optional.isPresent()) {
			ApplicationRepository.save(loanApplication);
			return loanApplication;
		} else {
			throw new InvalidLoanApplicationException("Loan application couldn't be Updated! ");
			// returns updated loan application

		}
	}

}
