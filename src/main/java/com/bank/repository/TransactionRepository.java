package com.bank.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	Page<Transaction> findAllByOperationDate(LocalDate operationDate, Pageable pageable);

}
