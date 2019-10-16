package com.techelevator;

import java.math.BigDecimal;

public class Lecture {

	public static void main(String[] args) {

		Auction firstAuction = new Auction("1963 Impala");
		
		System.out.println("High bid amount is: " + firstAuction.getHighBid().getBidAmount());
		
		Bid myBid = new Bid("David", 100);
		firstAuction.placeBid(myBid);
		
		System.out.println("High bid amount is: " + firstAuction.getHighBid().getBidAmount());
		
		
		firstAuction.placeBid(new Bid("Trey", 500));

		firstAuction.placeBid(new Bid("Brendan", 200));
		
		
		for (Bid b : firstAuction.getAllBids()) {
			System.out.println(b.getBidder() + " bid " + b.getBidAmount());
		}
		
		System.out.println("High bid amount is: " + firstAuction.getHighBid().getBidAmount());

		
		
		BuyoutAuction secondAuction = new BuyoutAuction("All the Beanie Babies", 2000);
		
		secondAuction.placeBid(new Bid("David", 365));
		secondAuction.placeBid(new Bid("Aaron", 400));
		secondAuction.placeBid(new Bid("Jill", 2100));
		secondAuction.placeBid(new Bid("Andrew", 2200));
		
		System.out.println("Winner is " + secondAuction.getHighBid().getBidder() + " who paid " 
										+ secondAuction.getHighBid().getBidAmount() + ".");
		
		ReserveAuction thirdAuction = new ReserveAuction("iPhone X", 1000);
		
		thirdAuction.placeBid(new Bid("Brendan", 500));
		thirdAuction.placeBid(new Bid("Anthony", 1));
		thirdAuction.placeBid(new Bid("Kyle", 1001));
		thirdAuction.placeBid(new Bid("Spencer", 1000));
		thirdAuction.placeBid(new Bid("Andrew", 999));
		
		System.out.println("Winner is " + thirdAuction.getHighBid().getBidder() + " who paid " 
				+ thirdAuction.getHighBid().getBidAmount() + ".");
		
		for (Bid b : thirdAuction.getAllBids()) {
			System.out.println(b.getBidder() + " bid " + b.getBidAmount());
		}
		
		
		BigDecimal amount = new BigDecimal("2.50");
		BigDecimal quarter = new BigDecimal("0.25");
		BigDecimal myAllowance = BigDecimal.ZERO;
		
		myAllowance = myAllowance.add(BigDecimal.valueOf(1.00));
		myAllowance = myAllowance.add(BigDecimal.valueOf(1.00));
		myAllowance = myAllowance.add(BigDecimal.valueOf(1.00));
		
		
		System.out.println(amount.add(quarter));
		System.out.println(amount);
		
		System.out.println(amount.add(BigDecimal.valueOf(.10)));
		
		
		if (myAllowance.compareTo(amount) == 1) {
			System.out.println("Allowance more than amount.");
		}
		else {
			System.out.println("Allowance not more than amount.");
		}

	}

}
