package com.techelevator.ssg.model.store;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CartItems {

	private int quantity;
	private Product p;
	private BigDecimal totalPerItem;
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return p;
	}
	public void setProduct(Product product) {
		this.p = product;
	}
	
	public BigDecimal getTotalPricePerItem() {
		totalPerItem = p.getPrice().multiply(new BigDecimal (quantity));	
		return totalPerItem;
	}
	
	
	
}
