package com.jdbc.models;

public class HTMLWidget extends Widget{
	String html;
	int order;
	String text;
	public static String type = "HTML";
	public HTMLWidget(int widgetId,int pageId, String name,String html, String text, int order) {
		super(widgetId, pageId, name, text, order, type);
		this.html = html;
		this.order = order;
		this.text = text;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

}
