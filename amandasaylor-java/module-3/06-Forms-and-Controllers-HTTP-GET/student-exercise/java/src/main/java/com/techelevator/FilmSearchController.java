package com.techelevator;

import com.techelevator.dao.FilmDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping("/films")
    public String showFilmSearchForm() {
    	return "filmList";
    }

    @RequestMapping("/filmSearchResults")
    public String searchFilms(@RequestParam String genre, @RequestParam int minLength, @RequestParam int maxLength,ModelMap modelMap) {
		modelMap.put("films", filmDao.getFilmsBetween(genre, minLength, maxLength));
		return "filmList";
    }
    
    
}