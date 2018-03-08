package com.jdbc.models;

public class HeadingWidget extends Widget{
	private int size;
	private int order;
	private String text;
	public static String type = "HEADING";
	
	public HeadingWidget(int widgetId, int pageId, String name, String text, int order) {
		super(widgetId, pageId, name, text, order, type);
		this.order = order;
		this.text = text;

	}
	
	public HeadingWidget(int widgetId, int pageId, String name, String text, int order, int size) {
		super(widgetId, pageId, name, text, order, type);
		this.order = order;
		this.text = text;
		this.size = size;
		this.type = "HEADING";
	}
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
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
}
