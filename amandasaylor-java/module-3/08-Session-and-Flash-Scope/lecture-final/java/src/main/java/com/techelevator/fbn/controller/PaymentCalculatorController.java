package com.techelevator.fbn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.fbn.model.MortgageLoanEstimate;

@Controller
public class PaymentCalculatorController {

	@RequestMapping("/mortgageCalculatorInput")
	public String showMortgagePaymentCalculatorInputPage() {
		return "mortgageCalculatorInput";
	}
	
	@RequestMapping("/mortgageCalculatorResult")
	public String showMortgagePaymentCalculatorResults(@RequestParam(defaultValue="0") int loanAmount,
													  @RequestParam int loanTerm,
													  @RequestParam(name="rate", defaultValue="0") double interestRate,
													  ModelMap model, RedirectAttributes ra) {
		
		
		if(loanAmount == 0 || interestRate == 0) {
			
			ra.addFlashAttribute("loanTerm", loanTerm);
			ra.addFlashAttribute("errorMessage", "Please fill in all fields!");
			
			return "redirect:/mortgageCalculatorInput";
		}
		
		
		MortgageLoanEstimate estimate = new MortgageLoanEstimate(loanAmount, loanTerm, interestRate/100);
		model.put("estimate", estimate);
		return "mortgageCalculatorResult";
	}
}











