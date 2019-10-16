package com.techelevator.person;

public class Person {

	private String firstName;
	private String lastName;
	private int age;
	
	public Person() {	
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	public boolean isAdult() {
		boolean adultAge = true;
		if (age >= 18) {
			return adultAge;
		}
		return false;
	}
}
