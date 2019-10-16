package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {
	
	private FrontTimes stringDivider = new FrontTimes();
	
	@Test 
	public void copied_string_combo() {
		
		String two = stringDivider.generateString("Chocolate", 2);
		String three = stringDivider.generateString("Chocolate", 3);
		String elementary = stringDivider.generateString("Abc", 3);
		
		Assert.assertEquals("ChoCho", two);
		Assert.assertEquals("ChoChoCho", three);
		Assert.assertEquals("AbcAbcAbc", elementary);

	}

}
/*
Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or
whatever is there if the string is less than length 3. Return n copies of the front;
frontTimes("Chocolate", 2) → "ChoCho"
frontTimes("Chocolate", 3) → "ChoChoCho"
frontTimes("Abc", 3) → "AbcAbcAbc"

public String generateString(String str, int n) {
String result = "";
if (str.length() <= 3) {
   for (int i = 0; i < n; i++) {
       result += str;
   }
} else {
   for (int i = 0; i < n; i++) {
       result += str.substring(0, 3);
   }
}
return result;
}*/
