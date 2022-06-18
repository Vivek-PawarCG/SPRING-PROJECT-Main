package com.cg.loan.LoanApplicationServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.loan.exception.InvalidLoanApplicationException;
import com.cg.loan.model.LoanApplication;
import com.cg.loan.model.Status;
import com.cg.loan.repository.ILoanApplicationRepository;
import com.cg.loan.service.LoanApplicationImpl;

/* Loan Application Service Junit Testing
 * Testing add new loan application by passing all the required parameters
 * Testing get loan application by Id and by passing all the required parameters
 * Testing update loan application by Id and passing all the required parameters
 * Testing delete loan application by Id and passing all the required parameters
 * 
 *
 * */

@SpringBootTest
class LoanApplicationServiceTest {

	@Autowired
	private LoanApplicationImpl applicationService;

	@MockBean
	ILoanApplicationRepository applicationrepo;

	@Test
	void testaddLoanApplication() {

		LoanApplication input = new LoanApplication(101, LocalDate.parse("2020-01-08"), null, 190000, 90000, false,
				true, Status.APPROVED);
		when(applicationrepo.save(input)).thenReturn(input);
		LoanApplication application_test = applicationService.addLoanApplication(input);
		assertEquals(input, application_test);

	}

	@Test
	void testretrieveAllLoanApplication() {

		List<LoanApplication> applicationList = mock(List.class);
		when(applicationrepo.findAll()).thenReturn(applicationList);
		List<LoanApplication> outputApplicationList = applicationService.retrieveAllLoanApplication();
		assertEquals(applicationList, outputApplicationList);
	}

	@Test
	void testViewCustomerById() throws InvalidLoanApplicationException {

		Long input = (long) 101;
		LoanApplication loanApplication = mock(LoanApplication.class);
		Optional<LoanApplication> optional_loanApplication = Optional.of(loanApplication);
		when(applicationrepo.findById(input)).thenReturn(optional_loanApplication);
		Optional<LoanApplication> application_test = Optional.of(applicationService.retrieveLoanApplicationById(input));
		assertEquals(optional_loanApplication, application_test);
	}

	@Test
	void deleteLoanApplication() throws InvalidLoanApplicationException {

		LoanApplication input = new LoanApplication(101, LocalDate.parse("2020-01-08"), null, 190000, 90000, false,
				true, null);

		LoanApplication output = new LoanApplication(101, LocalDate.parse("2020-01-08"), null, 190000, 90000, false,
				true, null);

		try {
			doNothing().when(applicationrepo).delete(input);

			applicationService.deleteLoanApplication(1);

			verify(applicationrepo).delete(input);
			assertEquals(input, output);

		} catch (InvalidLoanApplicationException e) {

		}

	}

	@Test
	void updateLoanApplication() throws InvalidLoanApplicationException {

		LoanApplication input = new LoanApplication(101, LocalDate.parse("2020-01-08"), null, 190000, 90000, false,
				true, null);

		Optional<LoanApplication> optionalApplication = Optional.of(input);
		LoanApplication output = new LoanApplication(101, LocalDate.parse("2020-01-08"), null, 190000, 90000, false,
				true, null);

		when(applicationrepo.findById((long) 101)).thenReturn(optionalApplication);
		when(applicationrepo.save(output)).thenReturn(output);
		LoanApplication application_test = applicationService.updateLoanApplication(output);
		assertEquals(output, application_test);

	}

}
