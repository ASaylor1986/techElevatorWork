package com.techelevator;
import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then display the change required.
 
 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {
 static Scanner input = new Scanner(System.in);
 
	public static void main(String[] args) {
System.out.print("Please enter the amount of the bill: " );
 String billTotal = input.nextLine();
 double amountOwed = Double.parseDouble(billTotal);
 
 System.out.print("Please enter the amount tendered: " ); 
 String amountTendered = input.nextLine();
 double amountPaid = Double.parseDouble(amountTendered);
 
 if(amountOwed > amountPaid) {
	 System.out.println("Need more money!");
 } 
 else if (amountOwed == amountPaid) {
	 System.out.println("No change for you!");
 } else {
 double changeRequired = amountPaid - amountOwed;
  
System.out.println("The change required is: " + changeRequired);

 
 
 
	}

}
}