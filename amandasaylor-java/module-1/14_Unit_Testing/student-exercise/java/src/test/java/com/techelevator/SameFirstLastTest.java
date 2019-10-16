package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {
	
	private SameFirstLast firstAndLast = new SameFirstLast();
	
	@Test 
	public void first_and_last_equal_each_other() {
		int[] array1 = {1, 2, 3};
		Assert.assertEquals(false, firstAndLast.isItTheSame(array1)); 
		
		int[] array2 = {1, 2, 3, 1};
		Assert.assertEquals(true, firstAndLast.isItTheSame(array2)); 
		
		int[] array3 = {1, 2, 1};
		Assert.assertEquals(true, firstAndLast.isItTheSame(array3)); 

	}

}
