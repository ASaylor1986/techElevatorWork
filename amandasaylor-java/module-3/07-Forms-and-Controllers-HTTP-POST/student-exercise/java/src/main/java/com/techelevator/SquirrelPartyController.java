package com.techelevator;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;





@Controller
public class SquirrelPartyController {
	
	@Autowired
	private ReviewDao reviewDao;
	

	
	
	@RequestMapping ("/") 
	public String displayAllReviews(ModelMap modelMap) {
		modelMap.put("reviews", reviewDao.getAllReviews());
		return "squirrelPartyHome";
	}
	
	
	@RequestMapping ("/newSquirrelPartyReview") 
	public String displayNewSquirrelPartyReview() {
		return "/newSquirrelPartyReview";
	}
	
	@RequestMapping (path="/newSquirrelPartyReview", method=RequestMethod.POST)
	public String displayNewSquirrelPartyReviewPage(@RequestParam String username, @RequestParam String title, @RequestParam String text, @RequestParam int rating) {
		Review review = new Review();
		LocalDateTime dateSubmitted = LocalDateTime.now();
		review.setUsername(username);
		review.setTitle(title);
		review.setText(text);
		review.setRating(rating);
		review.setDateSubmitted(dateSubmitted);
		reviewDao.save(review);
		return "redirect:/";
	}
}
