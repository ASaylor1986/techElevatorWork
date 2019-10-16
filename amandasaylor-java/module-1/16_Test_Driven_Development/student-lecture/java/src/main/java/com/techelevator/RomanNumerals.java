package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
	
	public static final int MAX_INPUT = 3000;
	private String doConversionStep(int value, String symbol, int increment) {
		
		String result = "";
		if (value >= increment) {	
			for (int i = 0; i < value/increment; i++) {
				result += symbol;	
			}
		}
		return result;
	}
	
	public String convert(int input) {

		String result = "";

		int[] increments = new int[] {1000, 100, 10, 1};
		
		Map<Integer, String> symbolMap = new HashMap<Integer, String>();
		symbolMap.put(1000,  "M");
		symbolMap.put(900,  "CM");
		symbolMap.put(500,  "D");
		symbolMap.put(400,  "CD");
		symbolMap.put(100,  "C");
		symbolMap.put(90,  "XD");
		symbolMap.put(50,  "L");
		symbolMap.put(40,  "XL");
		symbolMap.put(10,  "X");
		symbolMap.put(5,  "V");
		symbolMap.put(1,  "I");
		

		for(increment : symbolMap.keySet()) {
			result = result + doConversionStep(input, symbolMap.get(increment), increment);
			input = input % increment;
		}
		
		
		return result;
	}

}
