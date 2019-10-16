package com.techelevator;

public class SPUnextDay implements DeliveryDriver{

private String name = "SPU (Next Day)";
private int distance;
private double weight;
private double rate;

	public SPUnextDay() {
	}
	public String getName() {
		return name;
	}
	public int getDistance() {
		return distance;
	}
	public double getWeight() {
		return weight;
	}
	public double calculateRate(int distance, double weight) {
		rate = ((weight/16) * 0.075) * distance;
		return rate;
	}
	public double getRate() {
		return rate;
	}	
}
