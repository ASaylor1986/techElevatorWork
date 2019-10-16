package com.techelevator.farm;

import java.math.BigDecimal;

public abstract class Livestock extends FarmAnimal implements Sellable {
	
	private BigDecimal price;

	
	public Livestock(String name, String sound, BigDecimal price) {
		super(name, sound);
		this.price = price;
	}
	

	public BigDecimal getPrice() {
		return price;
	}
	
	@Override
	public String getAd() {
		return "And you can buy that " + getName() + " for only $" + getPrice() + "!";
	}
}
