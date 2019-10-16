package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class BidTest {
	
	@Test
	public void getBidder_returns_name_of_bidder() {	
		Bid b = new Bid("David", 100);
		String bidderName = b.getBidder();
		Assert.assertEquals("David", bidderName);		
	}
	
	@Test
	public void getBidAmount_returns_amount_of_bid() {	
		Bid b = new Bid("David", 100);
		int bidAmount = b.getBidAmount();
		Assert.assertEquals(100, bidAmount);		
	}

}
