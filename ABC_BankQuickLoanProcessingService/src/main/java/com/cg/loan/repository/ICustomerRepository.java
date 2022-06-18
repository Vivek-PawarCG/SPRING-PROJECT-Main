package com.cg.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.loan.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
}
