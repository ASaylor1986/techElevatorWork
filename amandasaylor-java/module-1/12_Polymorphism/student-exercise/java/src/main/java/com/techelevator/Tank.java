package com.techelevator;

public class Tank implements Vehicle{
	private double toll = 0;
	private String name = "Tank";
	private int distance;

	public Tank() {
		
	}
	public String getName() {
		return name;
	}
	public int getDistance() {
		return distance;
	}
	@Override
	public double calculateToll(int distance) {
		toll = 0;
		return toll;
	}
}
