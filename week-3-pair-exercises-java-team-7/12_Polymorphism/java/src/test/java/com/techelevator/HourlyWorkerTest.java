package com.techelevator;

import org.junit.Test;

import org.junit.Assert;


public class HourlyWorkerTest {

	@Test
	public void return_worker_first_name() {
		
		HourlyWorker testHourly = new HourlyWorker("Ted", "Bundy", 15.00);
		String firstName = testHourly.getFirstName();
		Assert.assertEquals("Ted", firstName);
	}
	
	@Test
	public void return_worker_last_name() {
		
		HourlyWorker testHourly = new HourlyWorker("Ted", "Bundy", 15.00);
		String lastName = testHourly.getLastName();
		Assert.assertEquals("Bundy", lastName);
	}
	
	@Test
	public void return_hourly_rate() {
		
		HourlyWorker testHourly = new HourlyWorker("Ted", "Bundy", 15.00);
		double rate = testHourly.hourlyRate();
		Assert.assertEquals(15, rate, 0.00);
		
	}
	
	@Test
	public void return_weekly_pay() {
	
		HourlyWorker testHourly = new HourlyWorker("Ted", "Bundy", 15.00);
		double weeklyPay = testHourly.calculateWeeklyPay(37);
		Assert.assertEquals(555, weeklyPay, 0);
	}
	
	}
