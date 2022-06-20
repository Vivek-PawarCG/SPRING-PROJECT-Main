package com.cg.loan.AdminServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.cg.loan.exception.LoanNotFoundException;

import com.cg.loan.model.Loan;
import com.cg.loan.repository.ILoanRepository;
import com.cg.loan.service.LoanServicesImpl;

@SpringBootTest
class AdminServiceTest {
	@Autowired
	private LoanServicesImpl loanService;
	
	@MockBean
	ILoanRepository loanRepo;
	
	
	  @Test 
	  public void testSaveAdmin() { 
	  Loan loanInput=new Loan(1, "Home Loan", 13, 1200000, 9.50);
	  when(loanRepo.save(loanInput)).thenReturn(loanInput); 
	  Loan loan_test = loanService.addLoan(loanInput); assertEquals(loanInput, loan_test);
	  }
	  @Test
		void testDeleteAdmin() throws LoanNotFoundException {
			Loan loanInput = new Loan(1, "Home Loan", 13, 1200000, 9.50);
			
			Loan loan_delete = new Loan(1, "Home Loan", 13, 1200000, 9.50);
			try {
				doNothing().when(loanRepo).delete(loanInput);

				loanService.deleteLoan(1);

				verify(loanRepo).delete(loanInput);
				assertEquals(loanInput, loan_delete);

			} catch (LoanNotFoundException e) {

			}
			
		}
		
		@Test
		void testUpdateLoan() throws LoanNotFoundException {

			Loan loanInput = new Loan(1, "Home Loan", 13, 1200000, 9.50);
			Optional<Loan> optionalLoan = Optional.of(loanInput);
			Loan updateLoan = new Loan(1, "Home Loan", 24, 1200000, 9.50);
			when(loanRepo.findById(1)).thenReturn(optionalLoan);
			when(loanRepo.save(updateLoan)).thenReturn(updateLoan);
			Loan loan_test = loanService.updateLoan(updateLoan);
			assertEquals(loanInput, loan_test);

		}
	 
	

}
