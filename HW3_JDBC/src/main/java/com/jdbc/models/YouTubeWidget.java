package com.jdbc.models;

public class YouTubeWidget extends Widget{
	private String url;
	private boolean shareable;
	private boolean expandable;
	private int order;
	public static String type = "YouTube";
	
	
	public YouTubeWidget(int widgetId,int pageId, String name, String text, int order,  String url, boolean shareable, boolean expandable) {
		super(widgetId, pageId, name, text, order, type);
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isShareable() {
		return shareable;
	}
	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}