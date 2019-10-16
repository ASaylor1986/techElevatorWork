package com.techelevator.farm;

import java.math.BigDecimal;

public class Corn implements Sellable, Edible {
	
	
	public BigDecimal getPrice() {
		return new BigDecimal("2.00");
	}
	
	public void isEaten() {
		
	}
	
	public boolean isGeneticallyModified() {
		return false;
	}
}
