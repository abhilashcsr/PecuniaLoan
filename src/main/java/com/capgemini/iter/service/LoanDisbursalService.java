package com.capgemini.iter.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.iter.controller.LoanDisbursal;



public interface LoanDisbursalService {
	public List<LoanDisbursal> getApproveLoans(ResponseEntity approves);

	List<LoanDisbursal> getApproveLoans(com.capgemini.iter.service.ResponseEntity<LoanRequests[]> approves);



}
© 2020 GitHub, Inc.