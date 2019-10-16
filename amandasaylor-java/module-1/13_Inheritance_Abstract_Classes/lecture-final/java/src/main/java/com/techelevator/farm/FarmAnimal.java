package com.techelevator.farm;

import java.math.BigDecimal;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean asleep = false;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}
	
	public String getName( ) {
		return name;
	}
	public final String getSound( ) {
		String result = sound;
		
		if (asleep) {
			result = "zzzzzz...";
		}
		
		return result;
	}
	
	
	
	public String getAd() {
		return null;
	}
	
	public boolean isAsleep() {
		return asleep;
	}
	
	public void sleep() {
		asleep = true;
	}
	
	public void wakeUp() {
		asleep = false;
	}
	
	
	public abstract String eat();
	
}