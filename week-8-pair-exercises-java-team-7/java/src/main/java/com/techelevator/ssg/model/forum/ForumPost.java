package com.techelevator.ssg.model.forum;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class ForumPost {
	private Long id;
	
	@NotBlank(message="You must provide your username.")

	private String username;
	
	@NotBlank(message="You must provide a subject.")
	@Length(min=2, message="The subject must be at least two characters.")
	private String subject;
	
	@NotBlank(message="You must provide a message.")
	private String message;
	private LocalDateTime datePosted;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(LocalDateTime datePosted) {
		this.datePosted = datePosted;
	}
	
	@AssertTrue(message="Username must be 20 characters or less.")
	public boolean isUsernameMeetingLengthReq() {
		return (username != null && username.length() <= 20);
	}
	
}
