package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankCustomer extends BankAccount{
	
	
	
	public BankCustomer() {
		myAccounts = new ArrayList <>();
	}
	

	private String name;
	private String address;
	private String phoneNumber;
	//public BankAccount accounts[];
	protected List<BankAccount> myAccounts; 

	
	public boolean getIsVIP() {
		boolean result = false;
		BigDecimal acctTotal = BigDecimal.ZERO;
		BigDecimal bigBaller = new BigDecimal (25000);
		for (BankAccount singleAcct : myAccounts) {
			acctTotal.add(singleAcct.getBalance());
		}
		if (acctTotal.compareTo(bigBaller) == 1) {
			result = true;
		}
		return result;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void addAccount(BankAccount newAccount) {
		myAccounts.add(newAccount);		
		}

	public List<BankAccount> getAccounts() {
		return new ArrayList<BankAccount>(myAccounts);
	}
	
	


	}
	

