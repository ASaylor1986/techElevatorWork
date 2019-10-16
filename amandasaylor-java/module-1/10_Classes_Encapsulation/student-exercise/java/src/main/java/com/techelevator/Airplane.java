package com.techelevator;



public class Airplane {
	
	private String planeNumber;
	private int bookedFirstClassSeats;
	private int availableFirstClassSeats;
	private int totalFirstClassSeats;
	private int bookedCoachSeats;
	private int availableCoachSeats;
	private int totalCoachSeats;
	//private int totalNumberOfSeats;
	//private boolean firstClass;
	
	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
	}
	public String getPlaneNumber() {
		return planeNumber;
	}
	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}
	public int getAvailableFirstClassSeats() {
		return (availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats);

	}
	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}
	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}
	public int getAvailableCoachSeats() {
		availableCoachSeats = totalCoachSeats - bookedCoachSeats;
		return availableCoachSeats;
	}
	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}
	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		boolean result = false;
		availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
		availableCoachSeats = totalCoachSeats - bookedCoachSeats;
		if(forFirstClass) {
			if (totalNumberOfSeats <= availableFirstClassSeats) {
				bookedFirstClassSeats += totalNumberOfSeats;
				result = true;
		}
		}
		if (!forFirstClass) {
			if (totalNumberOfSeats <= availableCoachSeats) {
				bookedCoachSeats += totalNumberOfSeats;
				result = true;
			}
		}
		else {
			return result;
		}
		return result;
	}

}
