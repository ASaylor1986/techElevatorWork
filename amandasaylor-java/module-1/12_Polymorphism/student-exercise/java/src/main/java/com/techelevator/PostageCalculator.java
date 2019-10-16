package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostageCalculator {

	
	static Scanner input = new Scanner(System.in);
	//private static double weight;
	
	public static void main(String[] args) {
		System.out.println("Please enter the weight of the package: " );
		String weightEntry = input.nextLine();
		
		System.out.print("(P)ounds or (O)unces? ");
		String answer = input.nextLine();
		double weight = 0;
		if (answer.equals("P")) {
			double poundToOunce = Double.parseDouble(weightEntry);
			weight = poundToOunce * 16;

		}
		if (answer.equals("O")) {
			weight = Double.parseDouble(weightEntry);
		}
		System.out.print("What distance will it be traveling?");
		String distanceStr = input.nextLine();
		int distance = Integer.parseInt(distanceStr);
		
		List<DeliveryDriver> shippingCost = new ArrayList<DeliveryDriver>();
		
		DeliveryDriver firstClass = new PostalService1stClass();
		shippingCost.add(firstClass);
		DeliveryDriver secondClass = new PostalService2ndClass();
		shippingCost.add(secondClass);
		DeliveryDriver thirdClass = new PostalService3rdClass();
		shippingCost.add(thirdClass);
		DeliveryDriver purpleShirts = new FexEd();
		shippingCost.add(purpleShirts);
		DeliveryDriver brownShirts1 = new SPUnextDay();
		shippingCost.add(brownShirts1);
		DeliveryDriver brownShirts2 = new SPUtwoDayBusiness();
		shippingCost.add(brownShirts2);
		DeliveryDriver brownShirts3 = new SPUfourDayGround();
		shippingCost.add(brownShirts3);
		
		System.out.format("%-30s%-10s\n", "Delivery Method", "$ cost");
		System.out.println("------------------------------------");

		for (DeliveryDriver packagePeeps : shippingCost) {
			
			String name = packagePeeps.getName();
			System.out.format("%-30s$%-5.2f\n", name, packagePeeps.calculateRate(distance, weight));
		}
	}
}
