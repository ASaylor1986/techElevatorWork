package com.techelevator.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Reservation;
import com.techelevator.model.ReservationDAO;


public class JDBCReservationDAO implements ReservationDAO{

	private JdbcTemplate jdbcTemplate;
	
	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Reservation> getAllReservations() {
		List<Reservation> reservation = new ArrayList<Reservation>();
		String sql = "SELECT reservation_id, site_id, from_date, to_date, created_date FROM reservation";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		Reservation r = null;
		
		while(results.next()) {
			r = new Reservation();
			r.setReservationId(results.getLong("reservation_id"));
			r.setSiteId(results.getLong("site_id"));
			r.setFromDate(results.getDate("from_date"));
			r.setToDate(results.getDate("to_date"));			
			r.setCreatedDate(results.getDate("created_date"));

			reservation.add(r);
		}
		
		return reservation;

	}

	@Override
	public List<Reservation> getReservationBySiteId(Long siteId) {
		List<Reservation> reservation = new ArrayList<Reservation>();
		String sql = "SELECT reservation_id, site_id, from_date, to_date, created_date FROM reservation WHERE site_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, siteId);
		Reservation r = null;
		
		while(results.next()) {
			r = new Reservation();
			r.setReservationId(results.getLong("reservation_id"));
			r.setSiteId(results.getLong("site_id"));
			r.setFromDate(results.getDate("from_date"));
			r.setToDate(results.getDate("to_date"));			
			r.setCreatedDate(results.getDate("created_date"));
			reservation.add(r);
		}
		return reservation;
	}
	
	@Override
	public String updateReservationList(Long siteId, String reservationName, LocalDate arrivalDate, LocalDate departureDate) {
		String sql = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date) VALUES (?,?,?,?,?) RETURNING reservation_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, siteId, reservationName, arrivalDate, departureDate, LocalDate.now());
		
		Long myReservation = null;
		if(results.next()) {
			myReservation = results.getLong("reservation_id");
			return "The reservation has been made and the confirmation id is " + myReservation;
		} else {
			return "Reservation cannot be made.";
		}
		
		
	}

}
