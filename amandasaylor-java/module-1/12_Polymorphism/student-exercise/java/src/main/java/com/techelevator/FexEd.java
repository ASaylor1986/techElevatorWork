package com.techelevator;

public class FexEd implements DeliveryDriver{
	
private String name = "FexEd";
private double excessMileRate = 5.00;
private int distance;
private double rate;
private double weight;
private double excessWeightCharge = 3.00;


	public FexEd() {
	}
	public String getName() {
		return name;
	}
	public double getExcessMileRate() {
		return excessMileRate;
	}
	
	public int getDistance() {
		return distance;
	}
	public double getWeight() {
		return weight;
	}
	public double getExcessWeightCharge() {
		return excessWeightCharge;
	}
	public double getRate() {
		return rate;
	}
	
	public double calculateRate(int distance, double weight) {
		rate = 20.00;
		if (weight > 48) {
			rate += 3.00;
		}
		if (distance > 500) {
			rate += 5.00;
		}
		return rate;
	}
}
