package com.techelevator.calculator;


public class Calculator {

	private int result;
	
	public Calculator() {
	}

	
	public int getResult() {
		return result;	
	}
	
	public int add(int addend) {
		return (result += addend);
	}

	public int multiply(int multiplier) {
		return (result = result*multiplier);
	}

	public int power(int exponent) {

		for (int i = 2; i <= exponent ; i++) {
			result *= result;
		}
		return (result);
		}
	

	public void reset() {	
		result = 0;
	}
	
	public int subtract(int subtrahend)	{
		result = result - subtrahend;
		return result;
	}
	
}