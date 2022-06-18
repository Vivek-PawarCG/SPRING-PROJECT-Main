package com.cg.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.loan.model.LoanApplication;

@Repository
public interface ILoanApprovalRepository extends JpaRepository<LoanApplication, Integer>{

}
