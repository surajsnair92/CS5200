package com.jdbc.models;

public class Role {
	private int roleId;
	private String roleType;
	private int developerId;
	private int websiteId;
	private int pageId;
	public Role() {
		super();
	}
	public Role(int roleId, int pageId, String roleType, int developerId) {
		super();
		this.roleId = roleId;
		this.roleType = roleType;
		this.developerId = developerId;
		this.pageId = pageId;
	}
	public Role(int roleId, String roleType, int websiteId,int developerId) {
		super();
		this.roleId = roleId;
		this.roleType = roleType;
		this.developerId = developerId;
		this.websiteId = websiteId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleName) {
		this.roleType = roleName;
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
