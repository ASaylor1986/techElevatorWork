package com.techelevator.ssg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.store.Cart;
import com.techelevator.ssg.model.store.CartItems;
import com.techelevator.ssg.model.store.DollarAmount;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;



@Controller
public class spaceStoreController {

	
	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping ("/spaceStore") 
	public String displayStore (ModelMap modelMap) {
	modelMap.put("products", productDao.getAllProducts());
	return "spaceStore";
	}
	
	@RequestMapping (path="/productDetails", method=RequestMethod.GET)
	public String displayProductDetails (ModelMap modelMap, @RequestParam long productId) {
		
		modelMap.put("selectedProduct", productDao.getProductById(productId));
		
		return "productDetails";
	}
	
	@RequestMapping (path="/productDetails", method=RequestMethod.POST)
	public String addToCartAndReturnToStore(ModelMap modelMap, @RequestParam long productId, @RequestParam int quantity, HttpSession session) {
		
		Cart shoppingCart = null;
		CartItems crt = new CartItems();
		Product p = productDao.getProductById(productId);
		crt.setProduct(p);
		crt.setQuantity(quantity);

		if (session.getAttribute("currentCart") == null) {
			
			shoppingCart = new Cart();
			shoppingCart.addItemToCart(crt);
			session.setAttribute("currentCart", shoppingCart);

		}
		else {
			shoppingCart = (Cart)session.getAttribute("currentCart");
		
		shoppingCart.addItemToCart(crt);
		}
				
		
		return "redirect:/spaceStore";
		//start working here!!
		//connect cart to page and test!!
	}
	
	
	@RequestMapping (path="/shoppingCart", method=RequestMethod.GET)
	public String displayShoppingCart (ModelMap modelMap, HttpSession session) {
		Cart finalCart = (Cart)session.getAttribute("currentCart");
		List<CartItems> finalList = new ArrayList<CartItems>();
		if (finalCart != null) {
			
			 finalList = finalCart.getItemList();
		}
		
		modelMap.put("cart", finalList);
		return "shoppingCart";
	}
	
	@RequestMapping (path="/shoppingCart", method=RequestMethod.POST) 
	public String finishPurchase (ModelMap modelMap, HttpSession session) {
		session.removeAttribute("currentCart");
		
		return "redirect:/spaceStore";
	}
	
}
