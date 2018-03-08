package com.jdbc.models;

public class ImageWidget extends Widget{
	String src;
	int order;
	public static String type = "IMAGE";

	public ImageWidget(int widgetId, int pageId, String name,  String text, int order, String src) {
		super(widgetId, pageId, name, text, order, type);
		this.src = src;
		this.order = order;
	}
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}

