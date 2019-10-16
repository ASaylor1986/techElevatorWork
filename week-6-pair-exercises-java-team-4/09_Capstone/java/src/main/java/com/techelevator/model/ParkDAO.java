package com.techelevator.model;

import java.util.List;



public interface ParkDAO {
	/**
	 * Get all parks from the datastore.
	 * 
	 * @return all parks as Park objects in a List
	 */
	public List<Park> getAllParks();
	
	public List<Park> getParkByName(String name);
}
