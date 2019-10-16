package com.techelevator.regex;

public class SimpleRegexDemo {
	
	public static void main(String[] args) {
		
		String s = "10+20-30 40";
		String[] stringArray = s.split(" |\\+|-"); // if want to split on a special character, put two forward slashes in front, inside the string
		
		for (String current : stringArray) {
			System.out.println(current);
		}
		
		
		
	}

}
