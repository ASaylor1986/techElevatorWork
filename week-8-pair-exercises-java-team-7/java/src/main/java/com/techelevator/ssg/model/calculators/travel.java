package com.techelevator.ssg.model.calculators;

public class travel {

	
	public String transportationType;
	public double speed;
	
	
	public travel(String transportationType, double speed) {
		this.transportationType= transportationType;
		this.speed = speed;
	}


	public String getTransportationType() {
		return transportationType;
	}


	public void setTransportationType(String transportationType) {
		this.transportationType = transportationType;
	}


	public double getSpeed() {
		return speed;
	}


	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
