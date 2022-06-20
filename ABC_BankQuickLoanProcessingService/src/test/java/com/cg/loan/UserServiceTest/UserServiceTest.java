package com.cg.loan.UserServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.loan.model.User;
import com.cg.loan.repository.IUserRepository;
import com.cg.loan.service.UserServiceImpl;

/* User Service JUnit Testing
 

 * */

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	private UserServiceImpl userService;
	
	@MockBean
	IUserRepository userRepo;
	
	
	@Test
	//Testing the condition by adding an Admin
	void addAdmin() {
	
		User input = new User(2,"Swathi","Admin");
		
		when(userRepo.save(input)).thenReturn(input);
	    User user_test = userService.addNewUser(input);
	    
	    
		assertEquals(input,user_test);
	}
	@Test
	//Testing the condition by adding an LADOfficer
	void addLADOfficer() {
	
		User input = new User(3,"Kalyani","LoanApprovalOfficer");
		
		when(userRepo.save(input)).thenReturn(input);
	    User user_test = userService.addNewUser(input);
	    
	    
		assertEquals(input,user_test);
	}
	@Test
	//Testing the condition by adding an Customer
	void addCustomer() {
	
		User input = new User(4,"Swapnil","Customer");
		
		when(userRepo.save(input)).thenReturn(input);
	    User user_test = userService.addNewUser(input);
    
		assertEquals(input,user_test);
	}
	

}
