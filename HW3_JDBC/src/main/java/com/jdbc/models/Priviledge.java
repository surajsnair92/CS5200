package com.jdbc.models;

public class Priviledge {
	private int roleId;
	private String priviledge;
	private int developerId;
	private int websiteId;
	private int pageId;
	public Priviledge() {
		super();
	}
	public Priviledge(int roleId, int pageId, String priviliedge, int developerId) {
		super();
		this.roleId = roleId;
		this.priviledge = priviliedge;
		this.developerId = developerId;
		this.pageId = pageId;
	}
	public Priviledge(int roleId, String priviliedge, int websiteId,int developerId) {
		super();
		this.roleId = roleId;
		this.priviledge = priviliedge;
		this.developerId = developerId;
		this.websiteId = websiteId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getPriviliedge() {
		return priviledge;
	}
	public void setPriviliedge(String priviliedge) {
		this.priviledge = priviliedge;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public int getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

}
