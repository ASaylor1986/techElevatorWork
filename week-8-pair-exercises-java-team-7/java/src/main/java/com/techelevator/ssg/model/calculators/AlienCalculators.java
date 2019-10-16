package com.techelevator.ssg.model.calculators;

public class AlienCalculators {
	
	public static final Planet[] PLANETS = {
		new Planet("Mercury", 87.96, 0.37, 56_974_146L),
		new Planet("Venus", 224.68, 0.90, 25_724_767L),
		new Planet("Mars", 686.98, 0.38, 48_678_219L),
		new Planet("Jupiter", 4329.63, 2.65, 390_674_710L),
		new Planet("Saturn", 10751.44, 1.13, 792_248_270L),
		new Planet("Uranus", 30685.55, 1.09, 1_692_662_530L),
		new Planet("Neptune", 60155.65, 1.43, 2_703_959_960L),
	};
	
	public static final travel[] VEHICLE = {
			new travel("Walking", 3),
			new travel("Car", 100),
			new travel("Bullet Train", 200),
			new travel("Boeing 747", 650),
			new travel("Concorde", 1350),

		};
	
	private static Planet getPlanetByName(String planetName) {
		Planet result = null;
		for (Planet p : PLANETS) {
			if (p.getName().equals(planetName)) {
				result = p;
			}
		}
		return result;
	}
	
	private static travel getVehicleByName(String vehicleName) {
		travel result = null;
		for (travel t : VEHICLE) {
			if (t.getTransportationType().equals(vehicleName)) {
				result = t;
			}
		}
		return result;
	}
	// Calculate the your age in terms of a named planet
	public static double calculateAlienAge(int earthYears, String planetName) {
		return (earthYears * 365) / getPlanetByName(planetName).getEarthDaysPerYear(); 
	}

	public static Object calculateAlienWeight(int earthWeight, String planetName) {
		return (earthWeight) * getPlanetByName(planetName).getEarthRelativeGravity();
	} 
	
	public static double calculateTravelTime(String vehicleName, String planetName) {
		return (getPlanetByName(planetName).getEarthDistance() / getVehicleByName(vehicleName).getSpeed());
	} 

}
