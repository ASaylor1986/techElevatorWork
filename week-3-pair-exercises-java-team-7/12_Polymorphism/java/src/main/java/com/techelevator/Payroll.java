package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Payroll {
	
	
	public static void main(String[] args) {
		
		List<WorkerInterface> employeePayroll = new ArrayList<WorkerInterface>();
		WorkerInterface employee = new SalaryWorker("Mickey", "Mouse,", 75000);
		employeePayroll.add(employee);
		
		employee = new HourlyWorker("George", "Geef,", 30);
		employeePayroll.add(employee);
		
		employee = new VolunteerWorker("Daisy", "Duck,");
		employeePayroll.add(employee);
		
		employee = new SalaryWorker("Minnie", "Mouse,", 2000000);
		employeePayroll.add(employee);
		
		
		System.out.format("%-20s%-15s%-20s\n", "Employee", "Hours Worked", "Pay");
		System.out.println("============================================");
		
		int allHours = 0;
		double allPay = 0;
		for(WorkerInterface worker : employeePayroll) {
			String firstName = worker.getFirstName();
			String lastName = worker.getLastName();
			Random rand = new Random();
			int hoursWorked = (rand.nextInt(80)+1);
			allHours += hoursWorked;
			allPay += worker.calculateWeeklyPay(hoursWorked);
			
			System.out.format("%-10s%-15s%-10d$%-20.2f\n", lastName, firstName, hoursWorked, worker.calculateWeeklyPay(hoursWorked));
		}
		System.out.println();
		System.out.format("%-10s%-20d", "Total Hours: ", allHours);
		System.out.println();
		System.out.format("\n%-10s%-20.2f", "Total Pay: $", allPay);
		
	}

}
