package com.techelevator;

import org.junit.Test;

import org.junit.Assert;

public class VolunteerWorkerTest {
	
	@Test
	public void get_workers_first_name() {
		
		VolunteerWorker testVolunteer = new VolunteerWorker ("Bob", "Smith");
		String volunteerFirstName = testVolunteer.getFirstName();
		Assert.assertEquals("Bob", volunteerFirstName);	
	}
	
	@Test
	public void get_workers_last_name() {
		VolunteerWorker testVolunteer = new VolunteerWorker ("Bob", "Smith");
		String volunteerLastName = testVolunteer.getLastName();
		Assert.assertEquals("Smith", volunteerLastName);
	}	
		
	@Test
	public void returns_weekly_pay() {
		VolunteerWorker testVolunteer = new VolunteerWorker ("Bob", "Smith");
		double weeklyPay = testVolunteer.calculateWeeklyPay(40);
		Assert.assertEquals(0, weeklyPay, 0);
		
	
	}
	
	@Test
	public void returns_hours_worked() {
		VolunteerWorker testVolunteer = new VolunteerWorker ("Bob", "Smith");
		int hours = testVolunteer.getHoursWorked();
		Assert.assertEquals(0, hours);

	}	
}
