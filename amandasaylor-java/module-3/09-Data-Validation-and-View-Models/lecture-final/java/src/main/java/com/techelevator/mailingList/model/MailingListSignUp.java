package com.techelevator.mailingList.model;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class MailingListSignUp {
	
	@NotBlank(message="You must provide your name.")
	private String name;

	@Email
	@NotBlank(message="Email address is required.")
	private String email;
	
	private String emailVerification;

	
	@NotBlank
	@Pattern(regexp="\\(\\d\\d\\d\\)\\d\\d\\d-\\d\\d\\d\\d", message="Invalid format")
	private String phone;

	@Range(min=1, max=130, message="That's a ridiculous age!")
	private int age;
	
	private String mailingAddress;
	
	@NotNull
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate subscribeDate;
	
	@AssertTrue(message="Email addresses do not match")
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
	public String getEmailVerification() {
		return emailVerification;
	}
	public void setEmailVerification(String emailVerification) {
		this.emailVerification = emailVerification;
	}
	public LocalDate getSubscribeDate() {
		return subscribeDate;
	}
	public void setSubscribeDate(LocalDate subscribeDate) {
		this.subscribeDate = subscribeDate;
	}
	
}
