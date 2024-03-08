package com.example.wissen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import com.example.wissen.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {
	public Account getByAccno(long accno);


	public List<Account> getByBalanceLessThan(double amount);
	public List<Account> getByBalanceGreaterThan(double amount);

}
