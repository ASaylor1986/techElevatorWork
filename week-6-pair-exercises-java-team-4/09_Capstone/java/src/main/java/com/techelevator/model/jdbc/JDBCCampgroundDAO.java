package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Campground;
import com.techelevator.model.CampgroundDAO;
import com.techelevator.model.Park;
import com.techelevator.model.ParkDAO;

public class JDBCCampgroundDAO implements CampgroundDAO{
	
	private JdbcTemplate jdbcTemplate;

	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Campground> getAllCampgrounds() {
		List<Campground> campgrounds = new ArrayList<Campground>();
		String sql = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee FROM campground LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		Campground c = null;
		
		while(results.next()) {
			c = new Campground();
			c.setCampgroundId(results.getLong("campground_id"));
			c.setParkId(results.getLong("park_id"));
			c.setName(results.getString("name"));
			c.setOpenFromMonth(results.getString("open_from_mm"));
			c.setOpenToMonth(results.getString("open_to_mm"));
			c.setDailyFee(results.getDouble("daily_fee"));
		
			campgrounds.add(c);
			
		}
		return campgrounds;
	}

	@Override
	public List<Campground> getCampgroundByParkId(Long parkId) {
		
		List<Campground> campgrounds = new ArrayList<Campground>();
		String sql = "SELECT campground_id, park_id, name, open_from_mm, open_to_mm, daily_fee FROM campground WHERE park_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
		Campground c = null;
		
		while(results.next()) {
			c = new Campground();
			c.setCampgroundId(results.getLong("campground_id"));
			c.setParkId(results.getLong("park_id"));
			c.setName(results.getString("name"));
			c.setOpenFromMonth(results.getString("open_from_mm"));
			c.setOpenToMonth(results.getString("open_to_mm"));
			c.setDailyFee(results.getDouble("daily_fee"));
		
			campgrounds.add(c);
			
		}
		
		return campgrounds;
	}
	
	@Override
	public Double getCampgroundCost(Long parkId, Long campgroundId) {
		List<Campground> campgrounds = new ArrayList<Campground>();
		String sql = "SELECT daily_fee FROM campground WHERE park_id = ? AND campground_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId, campgroundId);
		Campground c = null;
		while(results.next()) {
			c = new Campground();
			c.setDailyFee(results.getDouble("daily_fee"));
			campgrounds.add(c);
		}
		return c.getDailyFee();	
	}
	
	
	
}
