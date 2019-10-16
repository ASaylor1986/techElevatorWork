package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

	private Less20 modNumber;
	
	@Test
	public void is_the_number_a_mod_1_or_2() {
		modNumber = new Less20();
		Assert.assertTrue(modNumber.isLessThanMultipleOf20(19));
		Assert.assertTrue(modNumber.isLessThanMultipleOf20(18));
		Assert.assertFalse(modNumber.isLessThanMultipleOf20(16));
		
	}
}
