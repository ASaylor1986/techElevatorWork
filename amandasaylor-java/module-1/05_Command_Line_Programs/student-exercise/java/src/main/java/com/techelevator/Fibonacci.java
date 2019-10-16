package com.techelevator;
import java.util.Scanner;

public class Fibonacci {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Please enter Fibonacci number: " );
		String response = input.nextLine();

		 int n1 = 0;
		 int n2 = 1;
		 int n3 = n1 + n2;   
		 int fibCount= Integer.parseInt(response);    
		 System.out.print(n1+" "+n2);  
		    
		 for(int i = 2; i < fibCount ; i ++) {     
			 n3 = n1 + n2;  
			 n1 = n2;    
			 n2 = n3;   
			 System.out.print(" " + n3);    
		 }    
	}
}

