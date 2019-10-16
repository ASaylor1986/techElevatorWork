package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {

	private CigarParty squirrelsLikeToParty;

	
	@Test 
	public void was_not_the_weekend() {
		squirrelsLikeToParty = new CigarParty();
		Assert.assertFalse(squirrelsLikeToParty.haveParty(30, false));
		Assert.assertFalse(squirrelsLikeToParty.haveParty(99, false));
		Assert.assertTrue(squirrelsLikeToParty.haveParty(41, false));
		Assert.assertTrue(squirrelsLikeToParty.haveParty(59, false));
	}
	
	@Test 
	public void Was_party_time_for_cute_rats() {
		squirrelsLikeToParty = new CigarParty();
		Assert.assertTrue(squirrelsLikeToParty.haveParty(42, true));
		Assert.assertTrue(squirrelsLikeToParty.haveParty(99, true));
		Assert.assertFalse(squirrelsLikeToParty.haveParty(35, true));
		Assert.assertFalse(squirrelsLikeToParty.haveParty(39, true));
	}

}
