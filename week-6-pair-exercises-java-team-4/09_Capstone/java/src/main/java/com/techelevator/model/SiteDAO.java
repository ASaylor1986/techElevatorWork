package com.techelevator.model;

import java.util.List;



public interface SiteDAO {
	
	public List<Site> getAllSites();
	
	public List<Site> getSiteByCampgroundId(Long campgroundId);
	
	public List<Site> getAllAvailableSitesForReservation(Long campgroundId, String arrivalDate, String departureDate);
}
