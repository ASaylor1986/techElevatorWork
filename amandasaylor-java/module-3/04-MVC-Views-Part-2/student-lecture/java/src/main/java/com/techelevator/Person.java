package com.techelevator;

@SuppressWarnings("serial")
public class Person implements java.io.Serializable {
	private String firstName;
	private String lastName;
	private int age;
	
	public Person() {
		firstName = "";
		lastName = "";
		age = 0;
	}
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}	
	
	public boolean isAdult() {
		return age >= 18;
	}
}
