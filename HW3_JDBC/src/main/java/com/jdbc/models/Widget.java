package com.jdbc.models;

public class Widget {
	private int widgetId;
	private String name;
	private int width;
	private int height;
	private String cssClass;
	private String cssStyle;
	private String text;
	private int order;
	private int pageId;
	private String type;
	public Widget(int widgetId, int pageId, String name, String text, int order, String type) {
		super();
		this.widgetId = widgetId;
		this.name = name;
		this.text = text;
		this.order = order;
		this.pageId = pageId;
		this.type = type;
	}
	public Widget(int widgetId, int pageId, String name, String text) {
		super();
		this.widgetId = widgetId;
		this.name = name;
		this.text = text;
		this.pageId = pageId;
	}
	

	public int getWidgetId() {
		return widgetId;
	}
	public void setWidgetId(int widgetId) {
		this.widgetId = widgetId;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getCssStyle() {
		return cssStyle;
	}
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getType() {
		return type;
	}
}
