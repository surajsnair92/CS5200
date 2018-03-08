package com.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.models.Developer;
import com.jdbc.models.Page;
import com.jdbc.models.Website;

public class PageDao extends ConnectionDao {
	private static PageDao instance = null;
	final String createPage = "INSERT INTO Pages (pageId, websiteId, title, description, created, updated, visits) VALUES (?, ?, ?, ?, ?, ?, ?)";
	final String findAllPages = "SELECT * from Pages";
	final String findAllPageById = "SELECT * from Pages where websiteId = ?";
	final String findPageById = "SELECT * from Pages where pageId = ?";
	final String updatePage = "UPDATE Pages SET pageId = ?, websiteId = ?, title = ?, description = ?, created = ?, updated = ?, visits = ? where pageId = ?";
	final String deletePage = "DELETE FROM Pages where pageId = ?";
	
	final String cnetTitle = "UPDATE Page SET title = ? where websiteId = (SELECT websiteId from Website where websiteName = 'CNET')";
	final String deletelastUpdatedWiki = "delete p\n" + 
			"from Page p join (select max(updated) as maxupdated from Page) x\n" + 
			"on p.updated = x.maxupdated\n" + 
			"where p.websiteId = (SELECT developerId from Website where websiteName = 'Wikipedia')";
	private PageDao() {
	}
	public static PageDao getInstance() {
		if(instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	public int createPageForWebsite (int websiteId, Page p) {
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(createPage);
			pstmt.setInt(1, p.getPageId());
			pstmt.setInt(2, websiteId);
			pstmt.setString(3, p.getTitle());
			pstmt.setString(4, p.getDescription());
			pstmt.setDate(5, p.getCreated());
			pstmt.setDate(6, p.getUpdated());
			pstmt.setInt(7, p.getVisits());
			result = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Page> findAllPages() {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(findAllPages);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				int pageId = result.getInt("pageId");
				int websiteId = result.getInt("websiteId");
				String title = result.getString("title");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int visits = result.getInt("visits");
				
				Page page = new Page(pageId, websiteId, title, description, created, updated, visits);
				pages.add(page);
			}
			pstmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pages;
	}
	public ArrayList<Page> findPagesForWebsite(int websiteId) {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement psmt = null;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-nair.cvplzbt0w7bd.us-east-2.rds.amazonaws.com/hw2_nair_suraj_spring_2018";
		final String USERNAME = "suraj";
		final String PASSWORD = "nair1234";
		Developer developer = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			psmt = connection.prepareStatement(findAllPageById);
			psmt.setInt(1, websiteId);
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				int pageId = result.getInt("pageId");
				int webId = result.getInt("websiteId");
				String title = result.getString("title");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int visits = result.getInt("visits");
				
				Page page = new Page(pageId, webId, title, description, created, updated, visits);
				pages.add(page);
			}
			psmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pages;
	}
	public ArrayList<Page> findPageById(int pageId) {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-nair.cvplzbt0w7bd.us-east-2.rds.amazonaws.com/hw2_nair_suraj_spring_2018";
		final String USERNAME = "suraj";
		final String PASSWORD = "nair1234";
		Developer developer = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			pstmt = connection.prepareStatement(findPageById);
			pstmt.setInt(1, pageId);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				int pid = result.getInt("pageId");
				int webId = result.getInt("websiteId");
				String title = result.getString("title");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int visits = result.getInt("visits");
				
				Page page = new Page(pid, webId, title, description, created, updated, visits);
				pages.add(page);
			}
			pstmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pages;
	}
	
	public int updatePage(int pageId, Page p) {
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(updatePage);
			pstmt.setInt(1, pageId);
			pstmt.setInt(2, p.getWebsiteId());
			pstmt.setString(3, p.getTitle());
			pstmt.setString(4, p.getDescription());
			pstmt.setDate(5, p.getCreated());
			pstmt.setDate(6, p.getUpdated());
			pstmt.setInt(7, p.getVisits());
			pstmt.setInt(8, pageId);
			result = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deletePage(int pageId) {
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			// Statement for Developer
			PreparedStatement pstDeveloper = connection.prepareStatement(deletePage);
			pstDeveloper.setInt(1, pageId);
			result = pstDeveloper.executeUpdate();
			pstDeveloper.close();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int cnetTitle(String title ) {
		int result = -1;
		String newTitle = "CNET-" + title; 
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(updatePage);
			pstmt.setString(1, newTitle);
			result = pstmt.executeUpdate();
			pstmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deletelastUpdatedWiki() {
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			PreparedStatement pstDeveloper = connection.prepareStatement(deletelastUpdatedWiki);
			result = pstDeveloper.executeUpdate();
			pstDeveloper.close();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		PageDao pageDao = PageDao.getInstance();
//		Page home = new Page(1, 4, "Home", "Landing page",new Date(1992,3,4), new Date(2011,4,11),123434);
//		Page contact = new Page(2, 3, "Contact", "Addresses, phones, and contact info",new Date(1992,3,4), new Date(2011,4,11),345656);
		Page about = new Page(3, 6, "About", "Website description", new Date(1992,3,24), new Date(2011,10,15),234545);
		Page pref = new Page(4, 4, "Preferences", "Where users can configure their preferences", new Date(2011,3,4), new Date(2011,4,11),456776);
		Page profile = new Page(5, 5, "Profile", "Users can configure their personal", new Date(2014,11,24), new Date(2015,4,19),567878);
		
		pageDao.createPageForWebsite(5, profile);
		
		ArrayList<Page> pages = new ArrayList<Page>();
//		pages = pageDao.findAllPages();
//		pages = pageDao.findPageById(1);
//		pages = pageDao.findPagesForWebsite(3);
//		for (Page page : pages) {
//			System.out.println(page.getTitle());
//		}
//		Page homeUpdated = new Page(1, 4, "HomeUpdated", "Landing page",new Date(1992,3,4), new Date(2011,4,11),123434);
//		pageDao.updatePage(1, homeUpdated);
//		pages = pageDao.findAllPages();
//		for (Page page : pages) {
//			System.out.println(page.getTitle());
//		}
		
//		pageDao.deletePage(3);
	}
}
