package com.techelevator.farm;

import java.math.BigDecimal;

public class Chicken extends Livestock {
	
	public Chicken() {
		super("Chicken", "cluck!", BigDecimal.valueOf(1.75));
	}
	
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}
	
	@Override
	public String eat() {
		return "peck peck";
	}

}