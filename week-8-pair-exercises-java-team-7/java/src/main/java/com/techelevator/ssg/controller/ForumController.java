package com.techelevator.ssg.controller;

import java.time.LocalDate;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;

@Controller
public class ForumController {

	@Autowired
	private ForumDao forumDao;
	
	
	@RequestMapping ("/spaceForum") 
	public String displayForumPage(ModelMap modelMap) {
		modelMap.put("posts", forumDao.getAllPosts());
		return "spaceForum";

	}
	
	@RequestMapping (path="/newGeekPost", method=RequestMethod.GET) 
	public String displayNewGeekPost(ModelMap modelMap) {
		
		if(!modelMap.containsAttribute("newPost")) {
			ForumPost newForumPost = new ForumPost();
			modelMap.put("newPost", newForumPost);
		}
		return "newGeekPost";
	}
	
	@RequestMapping (path="/newGeekPost", method=RequestMethod.POST)
	public String displayNewGeekPostPage(@Valid @ModelAttribute ForumPost newPost, BindingResult result, RedirectAttributes redirectAttributes) {

		

		if(result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			
			redirectAttributes.addFlashAttribute("newPost", newPost);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "newPost", result);
			return "redirect:/newGeekPost";
		}
		LocalDateTime datePosted = LocalDateTime.now();
		newPost.setDatePosted(datePosted);
		forumDao.save(newPost);
		return "redirect:/spaceForum";
	}
	
}

