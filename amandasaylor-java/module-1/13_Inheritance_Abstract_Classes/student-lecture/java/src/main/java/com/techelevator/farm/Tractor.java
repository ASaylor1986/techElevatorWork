package com.techelevator.farm;

public class Tractor implements Singable {
	
	public String getName() {
		return "Tractor";
	}
	
	public String getSound() {
		return "vroom!";
	}
	
	public String getAd() {
		return ""; //don't want to advertise tractor
	}

}
