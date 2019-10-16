package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends Livestock {
	
	public Pig() {
		super("Pig", "oink!", BigDecimal.valueOf(650));
	}
	
	public String eat() {
		return "slop slop";
	}

}
