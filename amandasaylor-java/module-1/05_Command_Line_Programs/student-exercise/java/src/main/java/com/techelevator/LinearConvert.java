package com.techelevator;
import java.util.Scanner;

public class LinearConvert {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("Please enter length: " );
		String response = input.nextLine();
		
		System.out.print("Is the measurement in (m)eter, or (f)eet?  ");
		String answer = input.nextLine();


			if (answer.equals("m")) {
				int meters = Integer.parseInt(response);
				int calculatedFoot = (int) (meters * 3.2808399);
				System.out.println(meters + "m is " + calculatedFoot + "f." );
			}
			if (answer.equals("f")) {
				int foot = Integer.parseInt(response);
				int calculatedMeters = (int) (foot * 0.3048);
				System.out.println(foot + "f is " + calculatedMeters + "m." );
			}
		}
	}

