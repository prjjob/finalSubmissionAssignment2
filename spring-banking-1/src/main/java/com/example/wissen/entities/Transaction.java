package com.example.wissen.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTIONS")
public class Transaction {
	@Id
	private int t_id;
	private long from_acc;
	private long to_acc;
	private String ifsc;
	private double amount;
	
	
	public Transaction(int t_id, long from_acc, long to_acc, String ifsc, double amount) {
		super();
		this.t_id = t_id;
		this.from_acc = from_acc;
		this.to_acc = to_acc;
		this.ifsc = ifsc;
		this.amount = amount;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public long getFrom_acc() {
		return from_acc;
	}
	public void setFrom_acc(long from_acc) {
		this.from_acc = from_acc;
	}
	public long getTo_acc() {
		return to_acc;
	}
	public void setTo_acc(long to_acc) {
		this.to_acc = to_acc;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [t_id=" + t_id + ", from_acc=" + from_acc + ", to_acc=" + to_acc + ", ifsc=" + ifsc
				+ ", amount=" + amount + "]";
	}
	
	
	
}
