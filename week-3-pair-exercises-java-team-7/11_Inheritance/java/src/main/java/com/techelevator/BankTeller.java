package com.techelevator;

import java.math.BigDecimal;

public class BankTeller {

	public static void main(String[] args) {

		BankAccount checkingAccount = new CheckingAccount();
		BankAccount savingsAccount = new SavingsAccount();
		
		BankCustomer jayGatsby = new BankCustomer();
		
		jayGatsby.addAccount(checkingAccount);
		jayGatsby.addAccount(savingsAccount);
		
		System.out.println(String.format("Jay Gatsby has %s accounts.", jayGatsby.getAccounts().size()));
		savingsAccount.deposit(BigDecimal.valueOf(125));
		System.out.println(savingsAccount.getBalance());
		savingsAccount.withdraw(BigDecimal.valueOf(75));
		System.out.println(savingsAccount.getBalance());
		savingsAccount.transfer(checkingAccount, BigDecimal.valueOf(50));
		System.out.println(savingsAccount.getBalance());
		
		
		
		System.out.println(checkingAccount.getBalance());
		System.out.println("Is Jay Gatsby a VIP? " +jayGatsby.getIsVIP());
	
		
		
	}
	

	
}