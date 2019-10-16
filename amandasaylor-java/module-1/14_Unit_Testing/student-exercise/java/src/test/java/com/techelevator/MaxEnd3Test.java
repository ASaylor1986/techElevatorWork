package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {
	
	MaxEnd3 biggerNum = new MaxEnd3();

	@Test
	public void which_one_is_bigger() {
		
	
		int[] arrayDrivingMeCrazy = new int [] {1, 2, 3};
		int[] array2 = biggerNum.makeArray(arrayDrivingMeCrazy);
		int[] newArrayDrivingMeCrazy = {3, 3, 3};
		Assert.assertNotEquals(newArrayDrivingMeCrazy, array2); 
	}
	@Test
	public void this_one_is_bigger() {
		int[] secondArrayDrivingMeCrazy = new int [] {11, 5, 9};
		int[] array3 = biggerNum.makeArray(secondArrayDrivingMeCrazy);
		int[] newSecondArrayDrivingMeCrazy = {11, 11, 11};
		Assert.assertNotEquals(newSecondArrayDrivingMeCrazy, array3);
		
	}
	@Test
	public void no_this_one_is_bigger() {
		int[] thirdArrayDrivingMeCrazy = new int [] {2,11, 3};
		int[] array4 = biggerNum.makeArray(thirdArrayDrivingMeCrazy);
		int[] newThirdArrayDrivingMeCrazy = {3, 3, 3};
		Assert.assertNotEquals(newThirdArrayDrivingMeCrazy, array4);
		
	}
}
