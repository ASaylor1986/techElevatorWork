package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount{
	
	BigDecimal serviceFee = new BigDecimal("2.00");	
	BigDecimal minBalance = new BigDecimal("150.00");
	
	public SavingsAccount() {
		super();
	}
	
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		
		if (getBalance().compareTo(amountToWithdraw) >= 0) {
			super.withdraw(amountToWithdraw);
			if (getBalance().add(amountToWithdraw).compareTo(minBalance) == -1) {
				super.withdraw(serviceFee);
			}
		}

		return getBalance();
	}			
}
