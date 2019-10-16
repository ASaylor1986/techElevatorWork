package com.techelevator.model;

import java.util.List;



public interface CampgroundDAO {
	
	/**
	 * Get all campgrounds from the datastore.
	 * 
	 * @return all campgrounds as Department objects in a List
	 */
	public List<Campground> getAllCampgrounds();
	
	public List<Campground> getCampgroundByParkId(Long parkId);

	public Double getCampgroundCost(Long parkId, Long campgroundId);
}
