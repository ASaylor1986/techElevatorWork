package com.techelevator;

public class SPUfourDayGround implements DeliveryDriver{
	
private String name = "SPU (4-Day Ground)";
private int distance;
private double weight;
private double rate;


	public SPUfourDayGround() {	
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
		rate = ((weight/16) * 0.0050) * distance;
		return rate;
	}
	public double getRate() {
		return rate;
	}
}
