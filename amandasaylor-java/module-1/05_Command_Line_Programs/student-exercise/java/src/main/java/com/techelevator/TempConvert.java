package com.techelevator;
import java.util.Scanner;

public class TempConvert {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
	
	System.out.println("Please enter the temperature: " );
	String response = input.nextLine();
	
	System.out.print("Is the temperature celsius or fahrenheit (c/f)? ");
	String answer = input.nextLine();


		if (answer.equals("f")) {
			int fahrenheit = Integer.parseInt(response);
			int celsiusTemp = (int) ((fahrenheit - 32) / 1.8);
			System.out.println(fahrenheit + "F is " + celsiusTemp + "C" );
		}
		if (answer.equals("c")) {
			int celsius = Integer.parseInt(response);
			int fahrenheitTemp = (int) (celsius * 1.8 + 32);
			System.out.println(celsius + "C is " + fahrenheitTemp + "F" );
		}
	}
	


}


