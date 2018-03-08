package com.jdbc.models;

import java.sql.Date;

public class User extends Person{
	private boolean userAgreement;
	public boolean isUserAgreement() {
		return userAgreement;
	}
	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
	public User(int id, String firstName, String lastName, String username, String password, Date dob, String emailId, boolean userAgreement) {
		super(id, firstName, lastName, username, password, dob, emailId);
		this.userAgreement = userAgreement;
	}
}
