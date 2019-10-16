package com.techelevator;

import org.junit.After;  // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test;

public class BuyoutAuctionTest {
	
	@Test
	public void bids_greater_than_buyout_price_are_reduced_to_buyout_price() {
		
		BuyoutAuction theAuction = new BuyoutAuction("Thing", 200);
		
		theAuction.placeBid(new Bid("Little Spender", 1));
		theAuction.placeBid(new Bid("Big Spender", 1000));
		
		Bid highBid = theAuction.getHighBid();
		Assert.assertEquals(200, highBid.getBidAmount());
		
	}
	
	@Test
	public void bids_made_after_buyout_price_met_are_ignored() {
		
		BuyoutAuction theAuction = new BuyoutAuction("Thing", 200);
		
		theAuction.placeBid(new Bid("Buyout Bob", 200));
		theAuction.placeBid(new Bid("Too Late Tom", 201));
		
		Bid highBid = theAuction.getHighBid();
		Assert.assertEquals("Buyout Bob", highBid.getBidder());
		
	}
	
	@Test
	public void getBuyoutPrice_returns_buyout_price() {
		
		BuyoutAuction theAuction = new BuyoutAuction("Thing", 200);
		
		int buyoutPrice = theAuction.getBuyoutPrice();
		
		Assert.assertEquals(200, buyoutPrice);
		
	}
	

}
