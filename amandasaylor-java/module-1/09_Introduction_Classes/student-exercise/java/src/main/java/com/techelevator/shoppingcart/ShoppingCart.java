package com.techelevator.shoppingcart;

public class ShoppingCart {

	private int totalNumberOfItems;
	private double totalAmountOwed;
	
	public ShoppingCart() {
		totalNumberOfItems = 0;
		totalAmountOwed = 0;
	}
	
	public int getTotalNumberOfItems() {
		return totalNumberOfItems;	
	}
	public double getTotalAmountOwed() {
		return totalAmountOwed;
	}
	
	public void addItems(int numberOfItems, double pricePerItem) {
		totalNumberOfItems += numberOfItems;
		totalAmountOwed = (pricePerItem * numberOfItems);
	}
	public double getAveragePricePerItem() {
		double averagePricePerItem = 0;
		if (totalNumberOfItems == 0) {
			return averagePricePerItem;
		}
		else {
			averagePricePerItem = totalAmountOwed / totalNumberOfItems;
		}
		return averagePricePerItem;
	}
	public void empty() {
		totalNumberOfItems = 0;
		totalAmountOwed = 0;
	}
}
