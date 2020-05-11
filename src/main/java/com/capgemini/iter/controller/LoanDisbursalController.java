  
package com.capgemini.iter.controller;

import java.util.ArrayList;

import com.capgemini.iter.dto.LoanDisbursalDTO;

@RestController
@RequestMapping("/loan")
@CrossOrigin("http://localhost:4200")
public class LoanDisbursalController<RestTemplate, LoanRequests> {
	@Autowired
	RestTemplate rest;

	@Autowired
	LoanDisbursalDTO service;

	@GetMapping("/approvedrequests")
	@HystrixCommand(fallbackMethod = "allApprovedsFallback")
	public ArrayList<LoanDisbursal> allApproved() {
		ResponseEntity<LoanRequests[]> approves = rest.getForEntity("http://localhost:1005/loan/getAllRequests",
				LoanRequests[].class);

		return (ArrayList<LoanDisbursal>) service.getApproveLoans(approves);

	}

	@SuppressWarnings("unused")
	private ArrayList<LoanDisbursal> allApprovedsFallback() {
		LoanDisbursal loandis = new LoanDisbursal("SERVER DOWN", 0, 0, 0, 0, "SERVER DOWN", "SERVER DOWN", 0, 0);
		ArrayList<LoanDisbursal> al = new ArrayList<>();

		al.add(loandis);
		return al;

	}
}