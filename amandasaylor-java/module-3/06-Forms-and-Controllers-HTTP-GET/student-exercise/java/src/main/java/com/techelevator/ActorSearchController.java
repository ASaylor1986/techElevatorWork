package com.techelevator;

import java.util.Map;

import com.techelevator.dao.ActorDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class ActorSearchController {

	@Autowired
	private ActorDao actorDao;

	@RequestMapping("/actors")
	public String showSearchActorForm() {
		return "actorList";
	}

	@RequestMapping("/actorSearch")
	public String searchActors(@RequestParam String search, ModelMap modelMap) {
		modelMap.put("actors", actorDao.getMatchingActors(search));
		return "actorList";
	}
}
