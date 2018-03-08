package com.jdbc.models;

public class Phone {
	private int id;
	private int personId;
	private boolean primary;
	private String phone;
	
	public Phone(int id, int personId, boolean primary, String phone) {
		super();
		this.id = id;
		this.personId = personId;
		this.primary = primary;
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
