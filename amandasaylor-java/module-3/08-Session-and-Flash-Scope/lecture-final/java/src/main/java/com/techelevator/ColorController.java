package com.techelevator;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ColorController {
	
	@GetMapping("/colors")
	public String displayForm() {
		
		
		return "colors";
	}
	
	@PostMapping("/colors")
	public String setColor(@RequestParam String colorChoice, RedirectAttributes redirectAttributes) {
		System.out.println(colorChoice);
		redirectAttributes.addFlashAttribute("backgroundColor", colorChoice);
		return "redirect:/colors";
	}

}
