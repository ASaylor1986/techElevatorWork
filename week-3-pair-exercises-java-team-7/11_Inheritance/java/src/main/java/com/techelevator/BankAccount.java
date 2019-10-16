package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {
	
	
	protected String accountNumber;
	protected BigDecimal balance = BigDecimal.ZERO;

	//BankAccount myAccount = new BankAccount(String accountNumber, BigDecimal balance);
	
	public BankAccount() {
		
	}
	//BankAccount myAccount = new BankAccount();
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	private void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public BigDecimal deposit(BigDecimal amountToDeposit) {
		balance = balance.add(amountToDeposit);
		return balance;
	}
	public BigDecimal withdraw(BigDecimal amountToWithdraw) {
		balance = balance.subtract(amountToWithdraw);
		return balance;
	}
	
	public void transfer(BankAccount destinationAccount, BigDecimal transferAmount) {
		BigDecimal initialBalance = getBalance();
		BigDecimal finalBalance = this.withdraw(transferAmount);
		if(initialBalance.compareTo(finalBalance) != 0) {
			destinationAccount.deposit(transferAmount);
		}
	}
}

