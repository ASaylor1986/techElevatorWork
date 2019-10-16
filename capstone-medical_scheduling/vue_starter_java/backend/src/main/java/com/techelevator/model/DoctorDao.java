package com.techelevator.model;

import java.util.List;

public interface DoctorDao {
	
	public List<Doctor> getAllDoctors();
	
	
	public Doctor getDoctorById(long doctorId);

}
