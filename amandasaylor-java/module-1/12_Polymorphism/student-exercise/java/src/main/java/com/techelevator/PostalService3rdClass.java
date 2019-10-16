package com.techelevator;

public class PostalService3rdClass implements DeliveryDriver {

private String name = "Postal Service (3rd Class)";
private double perMileRate;
private int distance;
private double rate = perMileRate * distance;
private double weight;


	public PostalService3rdClass() {
	}

	public String getName() {
		return name;
	}
	public double getPerMileRate() {
		return perMileRate;
	}
	
	public int getDistance() {
		return distance;
	}
	public double getWeight() {
		return weight;
	}
	public double calculateRate(int distance, double weight) {
		if (weight <= 2) {
			perMileRate = 0.0020;
		}
		if (weight > 2 && weight <= 8) {
			perMileRate = 0.0022;
		}
		if (weight > 8 && weight <= 15) {
			perMileRate = 0.0024;
		}
		if (weight > 15 && weight <= 48) {
			perMileRate = 0.0150;
		}
		if (weight > 48 && weight <= 144) {
			perMileRate = 0.0160;
		}
		if (weight > 144) {
			perMileRate = 0.0170;
		}
		return rate = perMileRate * distance;
	}
	public double getRate() {
		return rate;
	}

}
