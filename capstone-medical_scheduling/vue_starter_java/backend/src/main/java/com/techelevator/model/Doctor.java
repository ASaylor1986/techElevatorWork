package com.techelevator.model;

public class Doctor {
	
	private String docFirstName;
	private String docLastName;
	private int userId;
	private int doctorId;
	private String userType;
	private String specialty;
	private String docPhone;
	private int officeId;
	
	
	public String getDocFirstName() {
		return docFirstName;
	}
	public void setDocFirstName(String docFirstName) {
		this.docFirstName = docFirstName;
	}
	public String getDocLastName() {
		return docLastName;
	}
	public void setDocLastName(String docLastName) {
		this.docLastName = docLastName;
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getDocPhone() {
		return docPhone;
	}
	public void setDocPhone(String docPhone) {
		this.docPhone = docPhone;
	}
	public int getOfficeId() {
		return officeId;
	}
	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
