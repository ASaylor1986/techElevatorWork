package com.techelevator;

import java.util.List;
import java.util.Map;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.CustomerDao;
import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Actor;
import com.techelevator.dao.model.Customer;
import com.techelevator.dao.model.Film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SearchRestController {

	private ActorDao actorDao;
	private FilmDao filmDao;
	private CustomerDao customerDao;
	
	@Autowired
	public SearchRestController(ActorDao actorDao, FilmDao filmDao, CustomerDao customerDao) {
		this.actorDao = actorDao;
		this.filmDao = filmDao;
		this.customerDao = customerDao;
	}

	
	@GetMapping("/actors")
	public List<Actor> searchActors(@RequestParam String search) {
		return actorDao.getMatchingActors(search);
	}
	
	@GetMapping("/films")
    public List<Film> searchFilms(@RequestParam(defaultValue="0") int minimumLength, @RequestParam(defaultValue="1000") int maximumLength, @RequestParam String genre) {
        return filmDao.getFilmsBetween(genre, minimumLength, maximumLength);
    }
	
	@GetMapping("/customers")
	public List<Customer> searchCustomers(@RequestParam(defaultValue="") String search,
										  @RequestParam(defaultValue="last_name") String sortBy) {
		return customerDao.searchAndSortCustomers(search, sortBy);
	}
}
