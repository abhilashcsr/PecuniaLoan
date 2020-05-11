package com.capgemini.iter.service;

import java.util.List;

import com.capgemini.iter.controller.Autowired;

@Service
public class LoanDisbursalServiceImp<LoanDisbursal> implements LoanDisbursalService {
	@Autowired
	LoanDisbursal dao;

	LoanDisbursal disburse = new LoanDisbursal();

	public List<com.capgemini.iter.controller.LoanDisbursal> getApproveLoans(ResponseEntity<LoanRequests[]> approves) {

		LoanRequests[] body = approves.getBody();
		for (int p = 0; p < body.length; p++) {
			LoanRequests l = body[p];
			if ((l.getCreditScore() >= 670) && (!(dao.existsById(l.getLoanId()))) ) {
				
					disburse.setAccountId(l.getAccountId());
					disburse.setCreditScore(l.getCreditScore());
					disburse.setLoanAmount(l.getLoanAmount());
					disburse.setLoanId(l.getLoanId());
					disburse.setLoanRoi(l.getLoanRoi());
					disburse.setLoanStatus("Accepted");
					disburse.setLoanTenure(l.getLoanTenure());
					disburse.setLoanType(l.getLoanType());
					double interest = (l.getLoanAmount() * l.getLoanTenure() * l.getLoanRoi() / (100 * 12));
					double emi = ((l.getLoanAmount() + interest) / l.getLoanTenure());
					emi = Math.round(emi * 100) / 100;
					disburse.setEmi(emi);
					dao.save(disburse);
				} 
			} 
		
		return dao.findAllAccepted();

	}

	public List<com.capgemini.iter.controller.LoanDisbursal> getApproveLoans(
			org.springframework.http.ResponseEntity approves) {
		// TODO Auto-generated method stub
		return null;
	}
}