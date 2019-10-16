package com.techelevator.model;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO {

	public List<Reservation> getAllReservations();
	
	public List<Reservation> getReservationBySiteId(Long siteId);
	
	public String updateReservationList(Long siteId, String reservationName, LocalDate arrivalDate, LocalDate departureDate);
}
