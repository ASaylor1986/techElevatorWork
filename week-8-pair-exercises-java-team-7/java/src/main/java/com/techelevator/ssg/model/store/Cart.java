package com.techelevator.ssg.model.store;

import java.util.ArrayList;
import java.util.List;



public class Cart {

//	private int numberMugs;
//	private int numberShirts;
//	private int numberCharts;
//	private int numberBooks;
//	
//	
//	
//	public int getNumberMugs() {
//		return numberMugs;
//	}
//	public void setNumberMugs(int numberMugs) {
//		this.numberMugs = numberMugs;
//	}
//	public int getNumberShirts() {
//		return numberShirts;
//	}
//	public void setNumberShirts(int numberShirts) {
//		this.numberShirts = numberShirts;
//	}
//	public int getNumberCharts() {
//		return numberCharts;
//	}
//	public void setNumberCharts(int numberCharts) {
//		this.numberCharts = numberCharts;
//	}
//	public int getNumberBooks() {
//		return numberBooks;
//	}
//	public void setNumberBooks(int numberBooks) {
//		this.numberBooks = numberBooks;
//	}
//	
//	
	
	private long productId;
	private int quantity;
	private List<CartItems> cartList = new ArrayList<CartItems>();
	
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void addItemToCart(CartItems cartItem) {
		cartList.add(cartItem);	
	}
	public List<CartItems> getItemList() {
		return cartList;
	}
	
	
	
	
}
