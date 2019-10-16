package com.techelevator;

public class SalaryWorker implements WorkerInterface {
		
		private double annualSalary;
		private double weeklyPay;	
		private String firstName;
		private String lastName; 
		private int hoursWorked;
		private double hourlyRate;
		
		public SalaryWorker(String firstName, String lastName, double annualSalary) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.annualSalary = annualSalary;
		}	
		public String getFirstName() {	
			return firstName;
		}

		public String getLastName() {		
			return lastName;
		}
		public double getAnnualSalary() {
			return annualSalary;
		}
		public int getHoursWorked() {
			return hoursWorked;
		}
		@Override
		public double calculateWeeklyPay(int hoursWorked) {
			weeklyPay = annualSalary / 52;
			return weeklyPay;
			
		}
		public double hourlyRate() {
			hourlyRate = weeklyPay / 40;
			return hourlyRate;
		}




		
		
		
		
		
		
		
}

		
