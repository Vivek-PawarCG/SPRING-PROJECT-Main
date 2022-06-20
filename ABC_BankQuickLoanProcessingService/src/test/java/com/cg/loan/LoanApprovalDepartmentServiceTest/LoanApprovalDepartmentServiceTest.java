package com.cg.loan.LoanApprovalDepartmentServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.loan.exception.InvalidLoanApplicationException;
import com.cg.loan.model.LoanApplication;
import com.cg.loan.model.Status;
import com.cg.loan.repository.ILoanApplicationRepository;
import com.cg.loan.service.LoanApprovalDepartmentImpl;

/* Loan Approval Department Service Testing
 
 * */

@SpringBootTest
class LoanApprovalDepartmentServiceTest {
	
	@Autowired
	private LoanApprovalDepartmentImpl loanapprovaldepartmentimpl;
	
	@MockBean
	ILoanApplicationRepository loanApplicationRepo;
	
	@Test
	//Testing the status update of loan approval by passing status of loan application
	void testUpdateStatus() throws InvalidLoanApplicationException {
		LoanApplication loanApplication = new LoanApplication(1,Status.APPROVED);

		
		Optional<LoanApplication> optionalApplication=Optional.of(loanApplication);
		LoanApplication updateLoanApplication = new LoanApplication(1,Status.APPROVED);
		when(loanApplicationRepo.findById((long) 1)).thenReturn(optionalApplication);
		when(loanApplicationRepo.save(updateLoanApplication)).thenReturn(updateLoanApplication);
		LoanApplication test_loanapplication=loanapprovaldepartmentimpl.updateStatus(updateLoanApplication);
		assertEquals(updateLoanApplication,test_loanapplication);
	}


}
