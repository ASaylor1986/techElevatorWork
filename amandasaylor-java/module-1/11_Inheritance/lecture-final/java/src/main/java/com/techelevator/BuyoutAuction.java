package com.techelevator;

public class BuyoutAuction extends Auction {

	
	private int buyoutPrice;
	
	public BuyoutAuction(String itemForSale, int buyoutPrice) {
		super(itemForSale);
		this.buyoutPrice = buyoutPrice;
	}
	
	public int getBuyoutPrice() {
		return buyoutPrice;
	}
	
	
	private boolean isAuctionOver() {
		return (getHighBid().getBidAmount() >= buyoutPrice);
	}
	
	@Override
	public boolean placeBid(Bid offeredBid) {
		boolean isCurrentWinningBid = false;
		
		if (isAuctionOver() == false) {
			
			
			if (offeredBid.getBidAmount() > buyoutPrice) {
				offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
			}
			
			isCurrentWinningBid = super.placeBid(offeredBid);
	
		}

		return isCurrentWinningBid;
	}
	
}
