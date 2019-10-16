package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {
	
	private Lucky13 noBadNums = new Lucky13();

	@Test
	public void is_there_1s_or_3s() {

		int[] arrayDrivingMeCrazy = {0, 2, 8};
		Assert.assertEquals(true, noBadNums.getLucky(arrayDrivingMeCrazy)); 
	}
	@Test
	public void there_is_no_1s_or_3s() {
	
		int[] everyArrayDrivingMeCrazy = {1, 3, 8};
		Assert.assertEquals(false, noBadNums.getLucky(everyArrayDrivingMeCrazy)); 	
	}
	
	
}

