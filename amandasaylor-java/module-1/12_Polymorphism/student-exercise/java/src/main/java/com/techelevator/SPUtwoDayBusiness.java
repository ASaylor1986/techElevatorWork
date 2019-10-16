package com.techelevator;

public class SPUtwoDayBusiness implements DeliveryDriver{

private String name = "SPU (2-Day Business) ";
private int distance;
private double weight;
private double rate;

	public SPUtwoDayBusiness() {		
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
		rate = ((weight/16) * 0.050) * distance;
		return rate;
	}
	public double getRate() {
		return rate;
	}
}
