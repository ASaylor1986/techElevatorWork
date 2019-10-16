package com.techelevator.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@Component
public class JdbcEventsDao implements EventsDao {
	private JdbcTemplate jdbcTemplate;
	
@Autowired
public JdbcEventsDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
}

	@Override
	public Events createEvent(Events event) {
		String insertsql = "INSERT INTO events (userid, usertype, start, \"end\", title, class, patientFirstName, patientLastName) " +
							"VALUES(?,?,?,?,?,?,?,?) RETURNING eventid";
	
	SqlRowSet results = jdbcTemplate.queryForRowSet(insertsql,event.getUserId(), event.getUserType(), event.getStart(), event.getEnd(),event.getTitle(),
				event.getType(), event.getPatientFirstName(), event.getPatientLastName());
		if(results.next()) {
			event.setEventId(results.getInt("eventid"));
		}
		return event;
	}
		
	@Override
	public Events updateEvent(Events event) {
	    String updateSql = "UPDATE events "
	            + "SET start = ?, \"end\" = ?, title = ?, class = ?, patientFirstName = ?, patientLastName = ? "
	            + "WHERE eventid = ?";
	
	    jdbcTemplate.update(updateSql, event.getStart(), event.getEnd(),
	    								 event.getTitle(), event.getType(), event.getPatientFirstName(), event.getPatientLastName(), event.getEventId());
	    
	    return event;
	}
	    
	@Override
	public void deleteEvent(int eventid) {
	    String deleteSql = "DELETE FROM events WHERE eventid = ?";
	    jdbcTemplate.update(deleteSql,eventid);
	  }

	@Override
	public Events readEvent(int eventid) {
		String sqlSelectEventByType = "SELECT * FROM events WHERE eventid = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectEventByType, eventid);
		if (results.next()) {
			return mapResultToEvent(results);
		} else {
		return null;
		}
	}

	@Override
	public List<Events> getAllEvents() {
		List<Events> events = new ArrayList<Events>();
		String sqlSelectEvents = "SELECT * FROM events";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectEvents);
		while (results.next()) {
			Events event = mapResultToEvent(results);
			events.add(event);
		}
		return events;
	}

	@Override
	public Events getEventsByUserType(String usertype) {
		String sqlSelectEventByType = "SELECT * FROM events WHERE usertype = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectEventByType, usertype);
		if (results.next()) {
			return mapResultToEvent(results);
		} else {
		return null;
		}
		
	}
	
	@Override
	public List<Events> getEventsByUserId(int userId) {
		List<Events> events = new ArrayList<Events>();
		String sqlSelectUserEvents = "SELECT * FROM events WHERE userid = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectUserEvents, userId);
		while (results.next()) {
			Events event = mapResultToEvent(results);
			events.add(event);
		}
		return events;
	}
	
	private Events mapResultToEvent(SqlRowSet results) {
		Events event = new Events();
		event.setUserId(results.getInt("userid"));
		event.setEnd(results.getString("end"));
		event.setEventId(results.getInt("eventid"));
		event.setStart(results.getString("start"));
		event.setUserType(results.getString("usertype"));
		event.setTitle(results.getString("title"));
		event.setType(results.getString("class"));
		event.setPatientFirstName(results.getString("patientFirstName"));
		event.setPatientLastName(results.getString("patientLastName"));
		
		return event;
	}

	

	


}
