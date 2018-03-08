package com.jdbc.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.models.Developer;
import com.jdbc.models.HTMLWidget;
import com.jdbc.models.HeadingWidget;
import com.jdbc.models.ImageWidget;
import com.jdbc.models.Page;
import com.jdbc.models.Website;
import com.jdbc.models.Widget;
import com.jdbc.models.YouTubeWidget;

public class WidgetDao extends ConnectionDao {
	public final String createWidget= "Insert into Widgets (widgetId, pageId, name, widgetText, widgetType, widgetOrder) VALUES (?, ?, ?, ?, ?, ?)";
	public final String findAllWidgets = "Select * from Widgets";
	public final String findWidgetById = "Select * from Widgets where widgetId = ?";
	public final String findWidgetByPageId = "Select * from Widgets where pageId = ?";
	public final String updateWidget = "Update Widgets SET widgetId = ?, pageId = ?, name = ?, widgetText = ?, widgetType = ?, widgetOrder = ? where widgetId = ?";
	public final String deleteWidget = "Delete from Widgets where widgetId = ?";
	
	// Update order. 
	public String updateOrderQ3 = "Update Widgets SET widgetOrder = 1 where widgetOrder = 2";
	public String updateOrderQ2 = "Update Widgets SET widgetOrder = 2 where widgetOrder = 1";
	public String updateOrderQ1 = "Update Widgets SET widgetOrder = ? where widgetName = ?";
	
	private static WidgetDao instance = null;
	public static WidgetDao getInstance() {
		if(instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	public int createWidgetForPage(int pageId, Widget widget) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			statement = connection.prepareStatement(createWidget);
			statement.setInt(1, widget.getWidgetId());
			statement.setInt(2, pageId);
			statement.setString(3, widget.getName());
			statement.setString(4, widget.getText());
			statement.setString(5, widget.getType());
			statement.setInt(6, widget.getOrder());
			result = statement.executeUpdate();
			statement.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<Widget> findAllWidgets() {
		ArrayList<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			statement = connection.prepareStatement(findAllWidgets);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int widgetId = result.getInt("widgetId");
				int pageId = result.getInt("pageId");
				String name = result.getString("name");
				String text = result.getString("widgetText");
				String type = result.getString("widgetType");
				int order = result.getInt("widgetOrder");
				Widget widget = new Widget(widgetId,pageId, name , text, order, type);
				widgets.add(widget);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return widgets;
	}
	
	public Widget findWidgetById(int widgetId) {
		ArrayList<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		Developer developer = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(findWidgetById);
			pstmt.setInt(1, widgetId);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				int widId = result.getInt("widgetId");
				int pageId = result.getInt("pageId");
				String name = result.getString("name");
				String text = result.getString("widgetText");
				String type = result.getString("widgetType");
				int order = result.getInt("widgetOrder");
				Widget widget = new Widget(widId,pageId, name , text, order, type);
				widgets.add(widget);
			}
			pstmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return widgets.get(0);
	}
	public ArrayList<Widget> findWidgetsForPage(int pageId) {
		ArrayList<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement psmt = null;
		Developer developer = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			psmt = connection.prepareStatement(findWidgetByPageId);
			psmt.setInt(1, pageId);
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				int widId = result.getInt("widgetId");
				int pid = result.getInt("pageId");
				String name = result.getString("name");
				String text = result.getString("widgetText");
				String type = result.getString("widgetType");
				int order = result.getInt("widgetOrder");
				Widget widget = new Widget(widId,pid, name , text, order, type);
				widgets.add(widget);
			}
			psmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return widgets;
	}
	public int updateWidget(int widgetId, Widget widget) {
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(updateWidget);
			pstmt.setInt(1, widgetId);
			pstmt.setInt(2, widget.getPageId());
			pstmt.setString(3, widget.getName());
			pstmt.setString(4, widget.getText());
			pstmt.setString(5, widget.getType());
			pstmt.setInt(6, widget.getOrder());
			pstmt.setInt(7, widgetId);
			result = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int deleteWidget(int widgetId) {
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			PreparedStatement pstmt = connection.prepareStatement(deleteWidget);
			pstmt.setInt(1, widgetId);
			result = pstmt.executeUpdate();
			pstmt.close();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	// Update widget order
	public int updateWidget(String widgetName, int targetOrder) {
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(updateOrderQ1);
			pstmt1 = connection.prepareStatement(updateOrderQ2);
			pstmt2 = connection.prepareStatement(updateOrderQ3);
			pstmt.setInt(1, targetOrder);
			pstmt.setString(2, widgetName);
			result = pstmt.executeUpdate();
			result = pstmt1.executeUpdate();
			result = pstmt2.executeUpdate();
			pstmt.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		WidgetDao widgetDao = WidgetDao.getInstance();
//		Widget head123 = new HeadingWidget(1, 123, "head123","Welcome", 0);
//		Widget head345 = new HeadingWidget(2, 1, "head345", "Hi", 1);
//		Widget intro = new HTMLWidget(4,2,"intro456","<h1>Hi</h1>", "text123", 3);
//		Widget image345 = new ImageWidget(3, 2, "image345", "images345", 3,"/img/567.png");
//		Widget video456 = new YouTubeWidget(6,2, "video456", "video text", 4, "https://www.youtube.com/watch?v=D-hz5ShjZTA", true, true);
//		Widget post234  = new HTMLWidget(2,3,"intro456","<p>Lorem</p>", "", 0);
		Widget head345 = new HeadingWidget(5, 2, "head345", "Hi", 1);
		widgetDao.createWidgetForPage(5, head345);
//		ArrayList<Widget> widgets = widgetDao.findAllWidgets();
//		for (Widget widget : widgets) {
//			System.out.println(widget.getType());
//		}
		
//		Widget w = widgetDao.findWidgetById(6);
//		System.out.println(w.getText());
		
//		ArrayList<Widget> widgets = widgetDao.findWidgetsForPage(2);
//		for (Widget widget : widgets) {
//			System.out.println(widget.getType());
//		}
		
//		Widget image345Updated = new ImageWidget(3, 2, "image345Updated", "images345", 3,"/img/345.png");
//		widgetDao.updateWidget(3, image345Updated);
//		widgetDao.deleteWidget(2);
		
	}
}
