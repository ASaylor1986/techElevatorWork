package com.techelevator.farm;

import java.math.BigDecimal;

public class Cow extends Livestock {

	public Cow() {
		super("Cow", "moo!", new BigDecimal("2000.00"));
	}
	
	public String eat() {
		return "chew chew";
	}

}