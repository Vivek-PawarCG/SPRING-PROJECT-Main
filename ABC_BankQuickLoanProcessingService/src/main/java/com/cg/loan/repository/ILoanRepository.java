package com.cg.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.loan.model.Loan;


@Repository
public interface ILoanRepository extends JpaRepository<Loan,Integer>{

}
