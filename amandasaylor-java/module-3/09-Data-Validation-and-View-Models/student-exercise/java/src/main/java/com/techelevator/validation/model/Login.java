package com.techelevator.validation.model;

import javax.validation.constraints.NotBlank;

public class Login {
	

	public String username;
	
    @NotBlank (message="Email is required")
	public String email;
	
    @NotBlank(message="Password is required")
	public String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
