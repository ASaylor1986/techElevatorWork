package com.techelevator.ssg.model.calculators;

public class Planet {
	
	private String name;
	private double earthDaysPerYear;
	private double earthRelativeGravity;
	private long earthDistance;
		
	public Planet(String name, double earthDaysPerYear, double earthRelativeGravity, long earthDistance) {
		this.name = name;
		this.earthDaysPerYear = earthDaysPerYear;
		this.earthRelativeGravity = earthRelativeGravity;
		this.earthDistance = earthDistance;
	}

	public String getName() {
		return name;
	}
	
	public double getEarthDaysPerYear() {
		return earthDaysPerYear;
	}
	
	public double getEarthRelativeGravity() {
		return earthRelativeGravity;
	}
	
	public long getEarthDistance() {
		return earthDistance;
	}
	
}
