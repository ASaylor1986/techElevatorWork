package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Park;
import com.techelevator.model.ParkDAO;

public class JDBCParkDAO implements ParkDAO{
	
	private JdbcTemplate jdbcTemplate;

	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		
		List<Park> parks = new ArrayList<Park>();
		String sql = "SELECT park_id, name, location, establish_date, area, visitors, description FROM park ORDER BY name ASC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		Park p = null;
		
		while(results.next()) {
			p = new Park();
			p.setId(results.getLong("park_id"));
			p.setName(results.getString("name"));
			p.setLocation(results.getString("location"));
			p.setDate(results.getDate("establish_date"));
			p.setArea(results.getInt("area"));
			p.setVisitors(results.getInt("visitors"));
			p.setDescription(results.getString("description"));
			parks.add(p);
		}
		return parks;	
	}
	
	@Override
	public List<Park> getParkByName(String choice) {
		
		List<Park> allParks = new ArrayList<Park>();
		String sql = "SELECT park_id, name, location, establish_date, area, visitors, description FROM park WHERE name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, choice);
		Park p = null;
		while(results.next()) {
			p = new Park();
			p.setId(results.getLong("park_id"));
			p.setName(results.getString("name"));
			p.setLocation(results.getString("location"));
			p.setDate(results.getDate("establish_date"));
			p.setArea(results.getInt("area"));
			p.setVisitors(results.getInt("visitors"));
			p.setDescription(results.getString("description"));
			allParks.add(p);
		}
		
		return allParks;
	}
}
