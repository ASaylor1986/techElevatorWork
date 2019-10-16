package com.techelevator;

public class Truck implements Vehicle{
	private int distance;
	private int numberOfAxles;
	private double toll;
	private double perMileRate;
	private String name;
	private String only4Axles = "Truck (4 axles)";
	private String only6Axles = "Truck (6 axles)";
	private String eightOrMoreAxles = "Truck (8 axles)";
	
	public Truck(int numberOfAxles) {
		this.numberOfAxles = numberOfAxles;
	}
	public String getName() {
		if (numberOfAxles == 4) { 
			name = only4Axles;
		}
		if (numberOfAxles == 6) { 
			name = only6Axles;
		}
		if (numberOfAxles >= 8) { 
			name = eightOrMoreAxles;
		}
		return name;
	}
	public int getNumberOfAxles() {
		return numberOfAxles;
	}
	public int getDistance() {
		return distance;
	}
	public double getToll() {
		return toll;
	}

	@Override
	public double calculateToll(int distance) {
		if (numberOfAxles == 4) {
			perMileRate = 0.040;
		}
		if (numberOfAxles == 6) {
			perMileRate = 0.045;
		}
		if (numberOfAxles >= 8) {
			perMileRate = 0.048;
		}
		return toll = perMileRate * distance;
	}
	
}
