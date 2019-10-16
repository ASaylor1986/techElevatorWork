package com.techelevator.model;

import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcDoctorDao implements DoctorDao{
	private JdbcTemplate jdbcTemplate;
	
@Autowired
public JdbcDoctorDao(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		String sqlSelectAllDoctors = "SELECT * FROM doctors";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllDoctors);
		while(results.next()) {
			Doctor doctor = mapResultToDoctor(results);
			doctors.add(doctor);
		}
		
		
		return doctors;
	}
	
	
	@Override
	public Doctor getDoctorById(long doctorId) {
		  String sqlSelectDoctorById = "SELECT * FROM doctors WHERE doctorid = ?";
	        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectDoctorById, doctorId);

	        if (results.next()) {
	            return mapResultToDoctor(results);
	        } else {
	            return null;
	        }
	    
	}
	
	private Doctor mapResultToDoctor(SqlRowSet results) {
		Doctor doctor = new Doctor();
		doctor.setDoctorId(results.getInt("doctorId"));
		doctor.setDocFirstName(results.getString("docFirstName"));
		doctor.setDocLastName(results.getString("docLastName"));
		doctor.setUserId(results.getInt("userId"));
		doctor.setUserType(results.getString("userType"));
		doctor.setSpecialty(results.getString("specialty"));
		doctor.setDocPhone(results.getString("docPhone"));
		doctor.setOfficeId(results.getInt("officeId"));

        
        return doctor;
    }
}
