package com.techelevator.validation.controller;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.techelevator.validation.model.Login;
import com.techelevator.validation.model.Registration;

@Controller
public class UserController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getMainScreen() {	
		return "homePage";
	}


	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String showRegistrationPage(ModelMap modelMap) {
		if(modelMap.containsAttribute("register") == false) {
		Login newSession = new Login();
		modelMap.put("newSession", newSession);
		}
		return "register";
	}

	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String registerNewUser(@Valid @ModelAttribute Registration newUser, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("registerNewUser", newUser);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "registerNewUser", result);
			return "redirect:/register";
		}
		return "redirect:/confirmation2";
	}


	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap modelMap) {
		if(modelMap.containsAttribute("signUp") == false) {
		Login newSession = new Login();
		modelMap.put("newSession", newSession);
		}
		return "login";
	}


	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String loginToPage(@Valid @ModelAttribute Login newLogin, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			redirectAttributes.addFlashAttribute("login", newLogin);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "login", result);
			return "redirect:/login";
		}
		return "redirect:/confirmation";
	}

	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String showConfirmationPage() {
		return "confirmation";
	}
	@RequestMapping(path="/confirmation2", method=RequestMethod.GET)
	public String showConfirmationPage2() {
		return "confirmation2";
	}
}
