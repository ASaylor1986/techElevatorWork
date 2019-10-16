package com.techelevator;


public class HourlyWorker implements WorkerInterface {
	
	private double weeklyPay;	
	private String firstName;
	private String lastName; 
	private int hoursWorked;
	private double hourlyRate;
	private double overtime;
	
	
	public HourlyWorker(String firstName, String lastName, double hourlyRate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyRate = hourlyRate;
	}
	public String getFirstName() {	
		return firstName;
	}

	public String getLastName() {		
		return lastName;
	}
	
	
	
//	public int getHoursWorked() {
//		return hoursWorked;
//	}
	
	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		double weeklyPay = hourlyRate * hoursWorked;
		double overtimePay = hoursWorked - 40;
		double totalPay = weeklyPay + (hourlyRate * overtime * .5);
		
		return totalPay;
	}
	public double hourlyRate() {
		return hourlyRate;	
	}

}
