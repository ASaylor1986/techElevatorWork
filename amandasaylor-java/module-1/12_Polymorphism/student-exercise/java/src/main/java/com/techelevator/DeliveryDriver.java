package com.techelevator;

public interface DeliveryDriver {

	public String getName();
	
	public double calculateRate(int distance, double weight);
		
}
