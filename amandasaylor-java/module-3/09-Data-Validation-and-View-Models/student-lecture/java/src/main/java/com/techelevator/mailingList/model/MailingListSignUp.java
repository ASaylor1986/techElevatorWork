package com.techelevator.mailingList.model;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class MailingListSignUp {
	
	@NotBlank(message="You must provide your name.")
	private String name;
	
	@Email
	@NotBlank(message="Your email address is required.")
	private String email;
	
	private String emailVerification;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@NotNull
	public LocalDate subscribeDate;
	
	public LocalDate getSubscribeDate() {
		return subscribeDate;
	}
	public void setSubscribeDate(LocalDate subscribeDate) {
		this.subscribeDate = subscribeDate;
	}
	public String getEmailVerification() {
		return emailVerification;
	}
	public void setEmailVerification(String emailVerification) {
		this.emailVerification = emailVerification;
	}

	@NotBlank(message="You must provide your phone number.")
	private String phone;
	@Range(min=1, max=130, message="That's a ridiculous age!")
	private int age;
	@NotBlank(message="Your mailing address is required.")
	private String mailingAddress;

	@AssertTrue(message="Email addresses do not match.")
	public boolean isEmailMatching() {
		return email != null && email.equals(emailVerification);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getMailingAddress() {
		return mailingAddress;
	}
	
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
}
