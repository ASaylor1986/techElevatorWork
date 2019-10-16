package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TollCalculator {

	public static void main(String[] args) {
		
		List<Vehicle> vroomVroom = new ArrayList<Vehicle>();
		
		Vehicle car = new Car(false);
		vroomVroom.add(car);
		Vehicle carWithTrailer = new Car(true);
		vroomVroom.add(carWithTrailer);
		Vehicle tank = new Tank();
		vroomVroom.add(tank);
		Vehicle truckWith4Axles = new Truck(4);
		vroomVroom.add(truckWith4Axles);
		Vehicle truckWith6Axles = new Truck(6);
		vroomVroom.add(truckWith6Axles);
		Vehicle truckWith8OrMoreAxles = new Truck(8);
		vroomVroom.add(truckWith8OrMoreAxles);
		
		System.out.format("%-20s%-20s%-5s\n", "Vehicle", "Distance Traveled", "Toll $");
		System.out.println("==============================================");
		
		int allMiles = 0;
		double allTolls = 0;
		for (Vehicle spinnyWheels : vroomVroom) {
			String name = spinnyWheels.getName();
			//int distance = spinnyWheels.getDistance();
			//Double toll = spinnyWheels.calculateToll(distance);
			Random rand = new Random();
			int miles = (rand.nextInt(240)+10);
			allMiles += miles;
			allTolls += spinnyWheels.calculateToll(miles);
			System.out.format("%-20s%-20d$%-5.2f\n", name, miles, spinnyWheels.calculateToll(miles));
		}
		System.out.println();
		System.out.format("%-10s%-20d", "Total Miles Traveled: ", allMiles);
		System.out.println();
		System.out.format("\n%-10s%-20.2f", "Total Tollbooth Revenue: $", allTolls);
		
	}
		
		
	
}
