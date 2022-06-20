package com.cg.loan.service;

import com.cg.loan.model.LoanApplication;
import com.cg.loan.exception.InvalidLoanApplicationException;

//LoanApprovalDepartment Interface

public interface ILoanApprovalDepartmentService  {
	
public LoanApplication updateStatus(LoanApplication loanApplication) throws InvalidLoanApplicationException ;

}
