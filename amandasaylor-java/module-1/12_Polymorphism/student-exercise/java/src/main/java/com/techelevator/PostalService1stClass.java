package com.techelevator;

public class PostalService1stClass implements DeliveryDriver {

private String name = "Postal Service (1st Class)";
private double perMileRate;
private int distance;
private double rate = perMileRate * distance;
private double weight;


	public PostalService1stClass() {
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
			perMileRate = 0.035;
		}
		if (weight > 2 && weight <= 8) {
			perMileRate = 0.040;
		}
		if (weight > 8 && weight <= 15) {
			perMileRate = 0.047;
		}
		if (weight > 15 && weight <= 48) {
			perMileRate = 0.195;
		}
		if (weight > 48 && weight <= 144) {
			perMileRate = 0.450;
		}
		if (weight > 144) {
			perMileRate = 0.500;
		}
		return rate = perMileRate * distance;
	}
	public double getRate() {
		return rate;
	}
}
