package com.techelevator.model;

import javax.validation.constraints.AssertTrue;

import javax.validation.constraints.NotBlank;


/**
 * User
 */
public class User {
	
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "User Type is required")
    private String userType;
    private long userId;

    @NotBlank(message = "Password is required")
    private String password;
    private String confirmPassword;

    private boolean passwordMatching;

    @AssertTrue(message = "Passwords must match")
    public boolean isPasswordMatching() {
        if (password != null) {
            return password.equals(confirmPassword);
        }
        return true;
    }
    @NotBlank(message = "First Name is required")
    private String firstName;
    
    @NotBlank(message = "Last Name is required")
    private String lastName;

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
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

	/**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the id
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param id the id to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return the role
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param role the role to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}