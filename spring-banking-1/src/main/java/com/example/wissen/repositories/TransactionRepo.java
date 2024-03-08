package com.example.wissen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wissen.entities.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>{
	
}
