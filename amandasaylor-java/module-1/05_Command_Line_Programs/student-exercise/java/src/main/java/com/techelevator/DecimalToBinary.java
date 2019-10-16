package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Please enter in a series of decimal values: " );
		String response = input.nextLine();
		String[] decimalNumbers = response.split(" ");

		
		for(int i = 0; i < decimalNumbers.length; i++) {
			int plainNumbers = Integer.parseInt(decimalNumbers[i]);
			String binary = Integer.toBinaryString(plainNumbers);
	        System.out.println(plainNumbers + " in binary is " + binary);
		}

}
}