package com.techelevator.validation.model;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class Registration {
	
	@NotBlank(message="You must provide your first name.")
	private String firstName;
	
	@NotBlank(message="You must provide your last name.")
	private String lastName;
	
	@Email
	@NotBlank(message="Your email address is required.")
	private String email;
	
	private String confirmEmail;
	
	@NotBlank(message="You must enter a password.")
	private String password;
	
	private String confirmPassword;
	
	@DateTimeFormat(pattern= "MM/dd/yyyy")
	@NotNull
	public LocalDate birthday;
	
	@NotNull
	@Range(min=1, max=10, message="# of tickets must be between 1 and 10.")
	public int numberOfTickets;
	
	
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}


	
	@AssertTrue(message="Email addresses do not match.")
	public boolean isEmailMatching() {
		return email != null && email.equals(confirmEmail);
	}

	@AssertTrue(message="Passwords do not match.")
	public boolean isPasswordMatching() {
		return password != null && password.equals(confirmPassword);
	}

}
