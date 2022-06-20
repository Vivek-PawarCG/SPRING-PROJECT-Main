package com.cg.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.loan.model.Customer;

@Repository
//is used to indicate that the class provides the mechanism for
//storage, retrieval, update, delete and search operation on objects

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
}
 //Customer Repository