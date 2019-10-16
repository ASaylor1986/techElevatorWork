package com.techelevator.model;

import java.sql.Date;

public class Reservation {
	
	private Long reservationId;
	private Long siteId;
	private String name;
	private Date fromDate;
	private Date toDate;
	private Date createdDate;
	



	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Long getSiteId() {
		return siteId;
	}
	
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getFromDate() {
		return fromDate;
	}
	
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	public Date getToDate() {
		return toDate;
	}
	
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
