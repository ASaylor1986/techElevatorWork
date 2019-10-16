package com.techelevator;

public class VolunteerWorker implements WorkerInterface {
	
	private double weeklyPay = 0;	
	private String firstName;
	private String lastName; 
	private int hoursWorked;
	
	
	public VolunteerWorker(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}


	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		weeklyPay = (hoursWorked * 0);
		return weeklyPay;
	}
	public String getFirstName() {	
		return firstName;
	}

	public String getLastName() {		
		return lastName;
	}
	
	public int getHoursWorked() {
		return hoursWorked;
	}



	
}
