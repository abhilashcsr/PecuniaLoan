package com.capgemini.iter.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class LoanDisbursalDTO {
	
	@Id
	private String accountId;
	private double amount;
	private int tenure;
	private int creditscore;
	private double roi;
	private String status;
	private String type;
	
	public LoanDisbursalDTO() {
		
	}
	
	
	public LoanDisbursalDTO(String accountId, double amount, int tenure, int creditscore, double roi, String status,
			String type) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.tenure = tenure;
		this.creditscore = creditscore;
		this.roi = roi;
		this.status = status;
		this.type = type;
	}


	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public int getCreditscore() {
		return creditscore;
	}
	public void setCreditscore(int creditscore) {
		this.creditscore = creditscore;
	}
	public double getRoi() {
		return roi;
	}
	public void setRoi(double roi) {
		this.roi = roi;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
