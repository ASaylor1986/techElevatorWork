package com.techelevator;

public class Car implements Vehicle{
	
	private int distance;
	private boolean hasTrailer;
	private double toll;
	private String name;
	private String car = "Car";
	private String carWithTrailer = "Car (with trailer)";
	
	public Car(boolean hasTrailer) {
		this.hasTrailer = hasTrailer;
	}
	public String getName() {
		if (!hasTrailer) { 
			name = car;
		}
		if (hasTrailer) { 
			name = carWithTrailer;
		}
		return name;
	}
	public boolean getHasTrailer() {
		return hasTrailer;
	}
	public int getDistance() {
		return distance;
	}
	@Override
	public double calculateToll(int distance) {
		if (!hasTrailer) { 
			toll = distance * 0.020;
		}
		if (hasTrailer) {
			toll = (distance * 0.020) + 1;
		}
		return toll;
	}

}
