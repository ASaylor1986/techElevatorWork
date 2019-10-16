package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuctionTest {
	
	
	private Auction testAuction;
	
	@Before
	public void setThingsUp() {
		testAuction = new Auction("Thing");
	}
	
	@Test
	public void high_bid_starts_at_zero() {
		 
		Bid startingHighBid = testAuction.getHighBid();
		
		int bidAmount = startingHighBid.getBidAmount();
		Assert.assertEquals(0, bidAmount);
	}
	
	@Test
	public void keeps_track_of_high_bid() {
		
		//Arrange
		testAuction.placeBid(new Bid("Larry", 100));
		testAuction.placeBid(new Bid("Moe", 150));
		testAuction.placeBid(new Bid("Curly", 125));
		
		//Act
		Bid highBid = testAuction.getHighBid();
		
		//Assert
		Assert.assertEquals("Moe", highBid.getBidder());
		Assert.assertEquals(150, highBid.getBidAmount());
		
	}
	
	@Test
	public void returns_all_bids_in_order_placed() {
		
		//Arrange
		testAuction.placeBid(new Bid("Larry", 100));
		testAuction.placeBid(new Bid("Moe", 150));
		testAuction.placeBid(new Bid("Curly", 125));
		
		//Act
		List<Bid> bids = testAuction.getAllBids();
		
		//Assert
		Assert.assertEquals("Larry", bids.get(0).getBidder());
		Assert.assertEquals("Moe", bids.get(1).getBidder());
		Assert.assertEquals("Curly", bids.get(2).getBidder());
	}
	
	@Test
	public void getItemForSale_returns_name_of_item() {
		
		String nameOfItem = testAuction.getItemForSale();
		Assert.assertEquals("Thing", nameOfItem);
	}
	

}
