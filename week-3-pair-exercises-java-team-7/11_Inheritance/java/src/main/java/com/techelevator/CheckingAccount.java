package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount{
	
	public CheckingAccount() {
		super();
	}
	


	BigDecimal overDraftFee = new BigDecimal("10.00");	
	BigDecimal wayOverDrawn = new BigDecimal("-100.00");
	
	
	@Override
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		
		if (getBalance().subtract(amountToWithdraw).compareTo(wayOverDrawn) >= 0) {
			super.withdraw(amountToWithdraw);
			if(getBalance().compareTo(BigDecimal.ZERO) == -1){
				super.withdraw(overDraftFee);
			}
		
		}	
		return getBalance();
	}


}
	


