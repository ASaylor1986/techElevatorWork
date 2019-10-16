package com.techelevator;

import org.junit.Test;

import org.junit.Assert;


public class SalaryWorkerTest {
	
	@Test
	public void get_workers_first_name() {
		
		SalaryWorker testSalaryWorker = new SalaryWorker ("Emily", "Meyers", 45000);
		String salaryFirstName = testSalaryWorker.getFirstName();
		Assert.assertEquals("Emily", salaryFirstName);	
	}
	
	@Test
	public void get_workers_last_name() {
		
		SalaryWorker testSalaryWorker = new SalaryWorker ("Emily", "Meyers", 45000);
		String salaryLastName = testSalaryWorker.getLastName();
		Assert.assertEquals("Meyers", salaryLastName);	
	}
	
	@Test
	public void get_workers_annual_salary() {
		
		SalaryWorker testSalaryWorker = new SalaryWorker ("Emily", "Meyers", 45000);
		double annualSalary = testSalaryWorker.getAnnualSalary();
		Assert.assertEquals(45000, annualSalary, 0);	
	}

	@Test
	public void returns_weekly_pay() {
		SalaryWorker testSalaryWorker = new SalaryWorker ("Bob", "Smith", 45000);
		double weeklyPay = testSalaryWorker.calculateWeeklyPay(40);
		Assert.assertEquals(865.38, weeklyPay, 0.1);
		
	
	}
	
	@Test
	public void returns_hours_worked() {
		SalaryWorker testSalaryWorker = new SalaryWorker ("Bob", "Smith", 45000);
		int hours = testSalaryWorker.getHoursWorked();
		Assert.assertEquals(0, hours);

	}	
	
	@Test
	public void returns_hourly_pay() {
		SalaryWorker testSalaryWorker = new SalaryWorker("John", "Doe", 15000);
		double hourlyPay = testSalaryWorker.hourlyRate();
		Assert.assertEquals(0, hourlyPay, 0);
		
	}
}
