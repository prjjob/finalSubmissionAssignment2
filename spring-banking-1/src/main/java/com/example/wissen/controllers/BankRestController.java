package com.example.wissen.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web .bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.wissen.entities.Account;
import com.example.wissen.entities.Transaction;
import com.example.wissen.repositories.AccountRepo;
import com.example.wissen.repositories.TransactionRepo;

@RestController
public class BankRestController {
	@Autowired
	AccountRepo repo;
	@Autowired
	TransactionRepo trepo;
	
	@GetMapping("/login")
	public boolean login(@RequestParam int cid, @RequestParam String pwd) {
		if(repo.existsById(cid))
		{
			Account a = repo.findById(cid).orElse(null);
			if(a!=null && a.getLatest_pw().equals(pwd)) {
				return true;
			}
		}
		return false;
		
	}
	
	@PostMapping("/register")
	public String addAccount(@RequestBody Account a) {
		if(repo.existsById(a.getCid())) {
			return "Sorry account already exists by this customer ID";
		}
		
		repo.save(a);
		return "Successfully registered";
	}
	
	@PutMapping("/changepwd/{cid}/{abc}/{xyz}")
	public String updatePassworrd(@PathVariable int cid, @PathVariable String abc, @PathVariable String  xyz) {
		if(!repo.existsById(cid)) return "cannot change password of user that does not exist";
		
		Account updatedAccount = repo.findById(cid).orElse(null);
		
		if(updatedAccount.getLatest_pw().equals(xyz)) return "same as previous password";
		
		
		updatedAccount.setPrev_pw(abc);
		updatedAccount.setLatest_pw(xyz);
		repo.save(updatedAccount);
		return "Successfully changed";
	}
	
	@PostMapping("/transfer")
	public String transferAmount(@RequestParam long fromAcc, @RequestParam long toAcc, @RequestParam String IFSC, @RequestParam double amount) {
		Account fromUser = repo.getByAccno(fromAcc);
		Account toUser = repo.getByAccno(toAcc);
		
		if(fromUser==null || toUser==null) return "From/To user does not exist";
		
		fromUser.setBalance(fromUser.getBalance() - amount);
		toUser.setBalance(toUser.getBalance() + amount);
		repo.save(fromUser);
		repo.save(toUser);
		int t_id = generateUniqueTid();
		Transaction t =new Transaction(t_id, fromAcc, toAcc, IFSC, amount );
		trepo.save(t);
		return "transaction successfull";
	}
	
	private int generateUniqueTid() {
		return this.hashCode();
	}

	@GetMapping("/balance/{accno}")
	public double getBalance(@PathVariable long accno) {
		if(repo.getByAccno(accno)==null) {
			return -1;
		}
		
		return repo.getByAccno(accno).getBalance();
		
	}
	
	@GetMapping("/accounts/below")
	public List<Account> getBelowBalance(@RequestParam double amount){
		List<Account> accounts = repo.getByBalanceLessThan(amount);
		return accounts;
	}
	
	@GetMapping("/accounts/above")
	public List<Account> getAboveBalance(@RequestParam double amount){
		List<Account> accounts = repo.getByBalanceGreaterThan(amount);
		return accounts;
	}
	
	
	
	
	
}
