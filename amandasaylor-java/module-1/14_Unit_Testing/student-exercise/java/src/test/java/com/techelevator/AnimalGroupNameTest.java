package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {
	
	private AnimalGroupName testAnimalNameAndHerd;
	
	@Before
	public void setThingsUp() {
		testAnimalNameAndHerd = new AnimalGroupName();
	}

	@Test
	public void get_animal_herd_name() {
		String groupName = testAnimalNameAndHerd.getHerd("Lion");
		Assert.assertEquals("Pride", groupName);	
	}
	
	@Test
	public void animal_herd_name_not_on_list() {
		String groupName = testAnimalNameAndHerd.getHerd("Wolf");
		Assert.assertEquals("unknown", groupName);	
	}
	

}
