package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {
	
	private StringBits partOfStrings = new StringBits();
	
	@Test
	public void every_other_letter() {
		String hello = partOfStrings.getBits("Hello");
		Assert.assertEquals("Hlo", hello);
		
		String hi = partOfStrings.getBits("Hi");
		Assert.assertEquals("H", hi);
		
		String heeololeo = partOfStrings.getBits("Heeololeo");
		Assert.assertEquals("Hello", heeololeo);
	}

}
