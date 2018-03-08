package com.jdbc.models;

import java.sql.Date;

public class Website extends Developer{
	private int websiteId;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private int visits;
	private int developerId;
	
	public Website(int websiteId, int developerId2, String name, String description,
			Date created, Date updated, int visits) {
		super();
		this.websiteId = websiteId;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.developerId = developerId2;
	}

	public int getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

}
