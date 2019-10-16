package com.techelevator.ssg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.calculators.AlienCalculators;

@Controller
public class CalculatorsController {
	
	
	@RequestMapping("/alienAge")
	public String alienAge(ModelMap modelMap) {
		modelMap.put("planets", AlienCalculators.PLANETS);
		return "alienAge";
	}
	
	@RequestMapping("/alienAgeResult")
	public String alienAgeResult(@RequestParam int earthAge, @RequestParam String planetName, ModelMap modelMap) {
		modelMap.put("alienAge", AlienCalculators.calculateAlienAge(earthAge, planetName));
		return "alienAgeResult";
	}
	
	@RequestMapping("/alienWeight")
	public String alienWeight(ModelMap modelMap) {
		modelMap.put("planets", AlienCalculators.PLANETS);
		return "alienWeight";
	}
	
	@RequestMapping("/alienWeightResult")
	public String alienWeightResult(@RequestParam int earthWeight, @RequestParam String planetName, ModelMap modelMap) {
		modelMap.put("alienWeight", AlienCalculators.calculateAlienWeight(earthWeight, planetName));
		return "alienWeightResult";
	}
	
	@RequestMapping("/alienTravelTime")
	public String alienTravelTime(ModelMap modelMap) {
		modelMap.put("planets", AlienCalculators.PLANETS);
		modelMap.put("vehicles", AlienCalculators.VEHICLE);
		return "alienTravelTime";
	}
	
	@RequestMapping("/alienTravelTimeResult")
	public String alienTravelTimeResult(@RequestParam String planetName, ModelMap modelMap, @RequestParam String vehicleName) {
		modelMap.put("alienTravelTime", AlienCalculators.calculateTravelTime(vehicleName, planetName));
		return "alienTravelTimeResult";
	}

//	@RequestMapping("/ageAfterTravel")
//	public String ageAfterTravel(ModelMap modelMap) {
//		modelMap.put("planets", AlienCalculators.PLANETS);
//		modelMap.put("vehicles", AlienCalculators.VEHICLE);
//		return "ageAfterTravel";
//	}
//	
//	@RequestMapping("/ageAfterTravelResult")
//	public String ageAfterTravelResult(@RequestParam int earthAge, @RequestParam String planetName, ModelMap modelMap, @RequestParam double speed) {
//		modelMap.put("ageAfterTravel", AlienCalculators.calculateAgeAfterTravel(earthAge, planetName, speed));
//		return "ageAfterTravelResult";
//	}

}
