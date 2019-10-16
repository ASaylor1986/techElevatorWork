package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {
	
	private DateFashion tableGame = new DateFashion();
	
	@Test 
	public void not_getting_a_table() {
		Assert.assertEquals(0, tableGame.getATable(1, 1));
		Assert.assertEquals(0, tableGame.getATable(9, 1));
		Assert.assertEquals(0, tableGame.getATable(1, 9));	
	}
	@Test 
	public void might_get_a_table() {
		Assert.assertEquals(1, tableGame.getATable(7, 4));
		Assert.assertEquals(1, tableGame.getATable(4, 7));
	}
	@Test 
	public void will_get_a_table() {
		Assert.assertEquals(2, tableGame.getATable(8, 9));
		Assert.assertEquals(2, tableGame.getATable(9, 8));
	}

}
