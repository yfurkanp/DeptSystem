package com.debtSystem.debtSystem.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.debtSystem.debtSystem.model.Debtor;

public interface DebtRepository extends JpaRepository<Debtor, Integer> {

	

}
