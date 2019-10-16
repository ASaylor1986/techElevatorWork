package com.techelevator.model;


import java.util.List;

public interface EventsDao {
	
	public List<Events> getAllEvents();
	
	public Events readEvent(int id);
	
	public Events createEvent(Events event);
	
	public Events updateEvent(Events event);
	
	public void deleteEvent(int id);
	
	public Events getEventsByUserType(String userType);
	
	public List<Events> getEventsByUserId(int userId);

	
		

}
