package com.jdbc.models;

import java.sql.Date;

public class Developer extends Person{
	private int developerId;
	private String developerKey;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Date dob;
	private String emailId;
	private int personId;
	public Developer() {
		super();
	}
	
	public Developer(int id, String firstName, String lastName, String username, String password, Date dob,
			String emailId, int developerId, String developerKey) {
		super(id, firstName, lastName, username, password, dob, emailId);
		this.developerId = developerId;
		this.developerKey = developerKey;
		this.personId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.emailId = emailId;
	}

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	
	
}
