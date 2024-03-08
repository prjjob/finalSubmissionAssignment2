package com.example.wissen.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNTS")
public class Account {
	@Id
	private int cid;
	private String IFSC;
	private double balance;
	private String acctype;
	private long mobile;
	private String latest_pw;
	private String prev_pw;
	private String name;
	private long accno;
	
	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getIFSC() {
		return IFSC;
	}


	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getAcctype() {
		return acctype;
	}


	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}


	public long getMobile() {
		return mobile;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public String getLatest_pw() {
		return latest_pw;
	}


	public void setLatest_pw(String latest_pw) {
		this.latest_pw = latest_pw;
	}


	public String getPrev_pw() {
		return prev_pw;
	}


	public void setPrev_pw(String prev_pw) {
		this.prev_pw = prev_pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Account [cid=" + cid + ", IFSC=" + IFSC + ", balance=" + balance + ", acctype=" + acctype + ", mobile="
				+ mobile + ", latest_pw=" + latest_pw + ", prev_pw=" + prev_pw + ", name=" + name + "]";
	}
	
	
	

	
	
	
	
	
}
