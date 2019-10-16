package com.techelevator.model.jdbc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Site;
import com.techelevator.model.SiteDAO;

public class JDBCSiteDAO implements SiteDAO{
	
	
	private JdbcTemplate jdbcTemplate;

	public JDBCSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Site> getAllSites() {
		List<Site> sites = new ArrayList<Site>();
		String sql = "SELECT site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities FROM site";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		Site s = null;
		
		while(results.next()) {
			s = new Site();
			s.setSiteId(results.getLong("site_id"));
			s.setCampgroundId(results.getLong("campground_id"));
			s.setSiteNumber(results.getLong("site_number"));
			s.setMaxOccupancy(results.getLong("max_occupancy"));
			s.setAccessible(results.getBoolean("accessible"));
			s.setMaxRvLength(results.getLong("max_rv_length"));
			s.setUtilities(results.getBoolean("utilities"));
			sites.add(s);
		}
		
		return sites;

	}

	@Override
	public List<Site> getSiteByCampgroundId(Long campgroundId) {
		List<Site> sites = new ArrayList<Site>();
		String sql = "SELECT site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities FROM site WHERE campground_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, campgroundId);
		Site s = null;
		
		while(results.next()) {
			s = new Site();
			s.setSiteId(results.getLong("site_id"));
			s.setCampgroundId(results.getLong("campground_id"));
			s.setSiteNumber(results.getLong("site_number"));
			s.setMaxOccupancy(results.getLong("max_occupancy"));
			s.setAccessible(results.getBoolean("accessible"));
			s.setMaxRvLength(results.getLong("max_rv_length"));
			s.setUtilities(results.getBoolean("utilities"));
			sites.add(s);
		}
		return sites;
	}
	
	@Override
	public List<Site> getAllAvailableSitesForReservation(Long campgroundId, String arrivalDate, String departureDate) {
		List<Site> sites = new ArrayList<Site>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate myArrival = LocalDate.parse(arrivalDate, formatter);
		LocalDate myDeparture = LocalDate.parse(departureDate, formatter);

		String sql = "Select site_number, max_occupancy, accessible, max_rv_length, utilities From site Where site_id Not In (Select site.site_id From site Join reservation On reservation.site_id = site.site_id Where (Not (reservation.to_date < ? Or reservation.from_date > ?))) And campground_id = ? And max_occupancy >= 1 And accessible >= 'false' And max_rv_length >= 0 And utilities >= 'false' Order By site_number LIMIT 5";
				
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, myArrival, myDeparture, campgroundId);
		
		Site s = null;
		
		while(results.next()) {
			s = new Site();
			s.setSiteNumber(results.getLong("site_number"));
			s.setMaxOccupancy(results.getLong("max_occupancy"));
			s.setAccessible(results.getBoolean("accessible"));
			s.setMaxRvLength(results.getLong("max_rv_length"));
			s.setUtilities(results.getBoolean("utilities"));
			sites.add(s);
		}
		return sites;
	}
	
	
}

