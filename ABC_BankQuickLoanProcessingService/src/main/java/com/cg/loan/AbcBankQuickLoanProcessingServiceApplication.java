package com.cg.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//This is the Main File

@SpringBootApplication  // triggers auto-configuration and component scanning

public class AbcBankQuickLoanProcessingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcBankQuickLoanProcessingServiceApplication.class, args);
		
		System.out.println("@@ App Started"); //to verify if application starts
	}

}
