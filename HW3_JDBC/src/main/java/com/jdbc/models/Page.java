package com.jdbc.models;

import java.sql.Date;

public class Page extends Developer{
	private int pageId;
	private String title;
	private String description;
	private Date created;
	private Date updated;
	private int visits;
	private int websiteId;
	
	public Page(int websiteId, int developerId2, String title, String description,
			Date created, Date updated, int visits) {
		super();
		this.pageId = websiteId;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.websiteId = developerId2;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = websiteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}

}
