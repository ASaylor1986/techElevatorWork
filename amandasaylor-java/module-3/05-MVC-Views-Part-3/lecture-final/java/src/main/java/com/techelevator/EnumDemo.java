package com.techelevator;

public class EnumDemo {
	
	
	public enum Season {SPRING, SUMMER, FALL, WINTER}
	
	public enum PhoneType { 
		ANDROID("Google"), IPHONE("Apple");
		
		private String maker;
		
		private PhoneType (String maker) {
			this.maker = maker;
		}
		
		public String getMaker() {
			return maker;
		}
	}
	

	public static void main(String[] args) {
		
		
		PhoneType pt;
		Season s;
		
		pt = PhoneType.IPHONE;
		s = Season.SUMMER;
		
		if (s == Season.SUMMER) {
			System.out.println("It's summertime!");
		}
		
		System.out.println(pt.getMaker());
		
		System.out.println(Season.FALL);

	}

}
