package com.jdbc.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.models.Developer;
import com.jdbc.models.Role;
import com.jdbc.models.Website;

// Have created two different tables for Roles that is WebsiteToles, PageRoles.
// Creating a single table for Privilege.
public class RoleDao extends ConnectionDao{
	final String assignWebsiteRole = "INSERT INTO WebsiteRoles (developerId, websiteId, roleId) VALUES (?, ?, ?)";
	final String assignPageRole = "INSERT INTO PageRoles (developerId, pageId, roleId) VALUES (?, ?, ?)";
	final String deleteWebsiteRole = "DELETE FROM WebsiteRoles WHERE roleId = ?";
	final String deletePageRole = "DELETE FROM PageRoles WHERE roleId = ?";
	
	final String temp = "Select d.developerId, p.username, r.developerId, r.pageId, r.roleId from"
			+ "(WebsiteRole r JOIN Developer) on d.developerId = r.developerId"
			+ "join Person p on p.personId = d.personId where r.pageId = "
			+ "select w.personId from Websites w join Pages p on w.websiteId = p.personId"
			+ "where w.websiteName = \"CNET\" and p.title = \"Home\"))";
	
	public final String swapRole = "Update Role r"
			+ "set r.roleId = CASE r.developerId "
			+ "when (select t.developerId from temp t where t.username = \"charlie\")"
			+ "then (select t.tempId from temp t wherer t.username = 'bob')"
			+ "when (select t.developerId from temp t where t.username = 'bob')"
			+ "then (select t.tempId from temp t where t.username = 'charlie'"
			+ "else (select t.tempId from temp t wherer t.developerId = r.developerId)"
			+ "end";
	public final String dropTempTable = "DROP TABLE temp";
	
	private static RoleDao instance = null;
	
	public static RoleDao getInstance() {
		if(instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	int assignWebsiteRole(int developerId, int websiteId, int roleId) {
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(assignWebsiteRole);
			pstmt.setInt(1, developerId);
			pstmt.setInt(2, websiteId);
			pstmt.setInt(3, roleId);
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

	
	int assignPageRole(int developerId, int pageId, int roleId) {
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(assignPageRole);
			pstmt.setInt(1, developerId);
			pstmt.setInt(2, pageId);
			pstmt.setInt(3, roleId);
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

	int deleteWebsiteRole(int developerId, int websiteId, int roleId){
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			PreparedStatement statement = connection.prepareStatement(deleteWebsiteRole);
			statement.setInt(1, roleId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	int deletePageRole(int developerId, int pageId, int roleId){
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			PreparedStatement statement = connection.prepareStatement(deletePageRole);
			statement.setInt(1, roleId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	void swapRoles() {
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			PreparedStatement statement = connection.prepareStatement(temp);
			result = statement.executeUpdate();
			PreparedStatement pstmt = connection.prepareStatement(swapRole);
			result = statement.executeUpdate();
			PreparedStatement drop = connection.prepareStatement(dropTempTable);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String...args) {
		RoleDao roleDao = RoleDao.getInstance();
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