package com.techelevator.model;

public class OfficeInfo {
	
	private int officeID;
	private String officeName;
	private String officeAddress;
	private String city;
	private String State;
	private int zip;
	private String phone;
	private int visitCost;
	private String weekdayHours;
	private String satHours;
	private String sunHours;
	
	
	public int getOfficeID() {
		return officeID;
	}
	
	public void setOfficeID(int id) {
		this.officeID = id;
	}
	
	public String getOfficeAddress() {
		return officeAddress;
		
	}
	
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	public String getOfficeName() {
		return officeName;
	}
	
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getVisitCost() {
		return visitCost;
	}
	public void setVisitCost(int visitCost) {
		this.visitCost = visitCost;
	}
	public String getWeekdayHours() {
		return weekdayHours;
	}
	public void setWeekdayHours(String weekdayHours) {
		this.weekdayHours = weekdayHours;
	}
	public String getSatHours() {
		return satHours;
	}
	public void setSatHours(String satHours) {
		this.satHours = satHours;
	}
	public String getSunHours() {
		return sunHours;
	}
	public void setSunHours(String sunHours) {
		this.sunHours = sunHours;
	}
	
	

}
