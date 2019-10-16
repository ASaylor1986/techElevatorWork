package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;

import com.techelevator.authentication.UnauthorizedException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.techelevator.model.Doctor;
import com.techelevator.model.DoctorDao;
import com.techelevator.model.Events;
import com.techelevator.model.EventsDao;
import com.techelevator.model.OfficeInfo;
import com.techelevator.model.OfficeInfoDao;
import com.techelevator.model.User;
import com.techelevator.model.UserDao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiController
 */

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {
	
    @Autowired
    private AuthProvider authProvider;
    
    @Autowired
    private OfficeInfoDao officeInfoDao;
    
    @Autowired
    private DoctorDao doctorDao;
    
    @Autowired
    private EventsDao eventsDao;
    
    @Autowired
    private UserDao userDao;
    

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String authorizedOnly() throws UnauthorizedException {
        /*
        You can lock down which roles are allowed by checking
        if the current user has a role.
        
        In this example, if the user does not have the admin role
        we send back an unauthorized error.
        */
        if (!authProvider.isUserType(new String[] { "doctor" })) {
            throw new UnauthorizedException();
        }
        return "Success";
    }
    
    @RequestMapping(path= "/info", method = RequestMethod.GET)
    public List<OfficeInfo> getOfficeInfo() {
    	return officeInfoDao.getAllOffices();
    
    }
    
    @GetMapping("/userInfo/{username}")
    public User getUser(String username) {
    	return userDao.getUserByUsername(username);
    }
 
    
    @GetMapping("/userInfo")
    public List<User> getUserInfo(){
    	return userDao.getAllUsers();
    }
    
    @GetMapping("/events")
    public List<Events> getAllEvents() {
    	return eventsDao.getAllEvents();
    }
    
    
	@PostMapping("/events")
	@ResponseStatus(HttpStatus.CREATED)
	public Events CreateEvents(@RequestBody Events event) {
		User currentUser = authProvider.getCurrentUser();
		event.setUserId(currentUser.getUserId());
		event.setUserType(currentUser.getUserType());
		return eventsDao.createEvent(event);
	}
	
    @GetMapping("/events/{id}")
    	public Events readEvents(@PathVariable int id) {
    		Events event = eventsDao.readEvent(id);
    		if(event != null) {
    			return event;
    		}else {
    			return null;
    		}
    	}
    
	@PutMapping("/events/{id}")	
	public Events update(@PathVariable int id, @RequestBody Events event) {
		Events requestedEvent = eventsDao.readEvent(id);
		if(requestedEvent != null) {
			event.setEventId(id);
			return eventsDao.updateEvent(event);
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/events/{id}")
	public Events delete(@PathVariable int id) {
		Events requestedEvent = eventsDao.readEvent(id);
		if(requestedEvent !=null) {
			eventsDao.deleteEvent(id);
			return requestedEvent;
		}else {
			return null;
		}
	}
	
	@GetMapping("/userevents/{id}")
    public List<Events> getEventsByUserId(@PathVariable int id) {
    	return eventsDao.getEventsByUserId(id);
    }
	
	@PutMapping("/info/{id}")	
	public OfficeInfo update(@PathVariable int id, @RequestBody OfficeInfo officeInfo) {
		OfficeInfo updateOffice = officeInfoDao.readOffice(id);
		if(updateOffice != null) {
			officeInfo.setOfficeID(id);
			return officeInfoDao.updateOfficeInfo(officeInfo);
		}else {
			return null;
		}
	}
}
    
   
    
  
    
    
    

    
