package com.jdbc.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.models.Developer;
import com.jdbc.models.Priviledge;
import com.jdbc.models.Role;
import com.jdbc.models.Website;


public class PriviledgeDao extends ConnectionDao{
	final String assignWebsitePriviledge = "INSERT INTO WebsitePriviledges (developerId, websiteId, priviledgeId) VALUES (?, ?, ?, ?)";
	final String assignPagePriviledge = "INSERT INTO PagePriviledges (developerId, pageId, priviledgeId) VALUES (?, ?, ?, ?)";
	final String deleteWebsitePriviledge = "DELETE FROM WebsitePriviledges WHERE priviledgeId = ?";
	final String deletePagePriviledge = "DELETE FROM PagePriviledges WHERE priviledgeId = ?";
	private static PriviledgeDao instance = null;

	public static PriviledgeDao getInstance() {
		if(instance == null) {
			instance = new PriviledgeDao();
		}
		return instance;
	}
	int assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			statement = connection.prepareStatement(assignWebsitePriviledge);
			statement.setInt(1, developerId);
			statement.setInt(2, websiteId);
			statement.setInt(3, priviledgeId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	int	assignPagePriviledge(int developerId, int pageId, int priviledgeId){
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(assignPagePriviledge);
			pstmt.setInt(1, developerId);
			pstmt.setInt(2, pageId);
			pstmt.setInt(3, priviledgeId);
			result = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	int deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId) {
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			PreparedStatement statement = connection.prepareStatement(deleteWebsitePriviledge);
			statement.setInt(1, priviledgeId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	int deletePageRole(int developerId, int pageId, int roleId){
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			PreparedStatement statement = connection.prepareStatement(deletePagePriviledge);
			statement.setInt(1, roleId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String...args) {
		PriviledgeDao roleDao = PriviledgeDao.getInstance();
		//		Role fbOwner = new Role(1, "owner", 1, 5);
		//		roleDao.assignWebsiteRole(5,1,fbOwner);
		//		Role ob = new Role(2,"owner", 2, 6);
		//		Role ob = new Role(3,"owner", 3, 7);
		//		Role ob = new Role(4,"owner", 4, 5);
		//		Role ob = new Role(5,"owner", 5, 6);
		//		Role ob = new Role(7,"editor", 1, 6);
		//		Role ob = new Role(8,"editor", 2, 7);
		//		Role ob = new Role(9,"editor", 3, 5);
		//		Role ob = new Role(10,"editor", 4, 6);
		//		Role ob = new Role(11,"editor", 5, 7);
		//		Role ob = new Role(12,"editor", 6, 5);
		//		Role ob = new Role(13,"admin", 1, 7);
		//		Role ob = new Role(14,"admin", 2, 5);
		//		Role ob = new Role(15,"admin", 3, 6);
		//		Role ob = new Role(16,"admin", 4, 7);
		//		Role ob = new Role(17,"admin", 5, 5);
		//		Role ob = new Role(18,"admin", 6, 6);
		//		Role ob = new Role(19, 1, "editor", 5);
		//		Role ob = new Role(20, 3, "editor", 6);
		//		Role ob = new Role(21, 2, "editor", 7);
		//		Role ob = new Role(22, 4, "editor", 5);
		//		Role ob = new Role(23, 5, "editor", 6);
		//		Role ob = new Role(24, 1, "reviewer", 6);
		//		Role ob = new Role(25, 1, "reviewer", 7);
		//		Role ob = new Role(26, 1, "reviewer", 5);
		//		Role ob = new Role(27, 1, "reviewer", 6);
		//		Role ob = new Role(28, 1, "reviewer", 7);
		//		Role ob = new Role(29, 1, "writer", 7);
		//		Role ob = new Role(30, 3, "writer", 5);
		//		Role ob = new Role(31, 2, "writer", 6);
		//		Role ob = new Role(32, 4, "writer", 7);
		//		Role ob = new Role(33, 5, "writer", 5);
		//		Role ob = new Role(18,"admin", 6, 6);
		//		roleDao.assignWebsiteRole(6, 6, ob);
		//		roleDao.deleteWebsiteRole(6, 6, 18);
	}
}