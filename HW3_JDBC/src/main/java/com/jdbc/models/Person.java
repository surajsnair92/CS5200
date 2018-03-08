package com.jdbc.models;

import java.sql.Date;

public class Person {
	private int personId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Date dob;
	private String emailId;
	public Person() {
		super();
	}
	public Person(int id, String firstName, String lastName, String username, String password, Date dob, String emailId) {
		this.personId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.emailId = emailId;
	}
	public int getPid() {
		return personId;
	}
	public void setPid(int pid) {
		this.personId = pid;
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
	
	
}
