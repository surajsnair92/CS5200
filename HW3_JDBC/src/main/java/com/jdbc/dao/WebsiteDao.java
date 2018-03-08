package com.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.models.Developer;
import com.jdbc.models.Website;

public class WebsiteDao extends ConnectionDao {
	private static WebsiteDao instance = null;
	final String createWebsite = "INSERT INTO Websites (websiteId, developerId, websiteName, description, created, updated, visits) VALUES (?, ?, ?, ?, ?, ?, ?)";
	final String findAllWebsites = "SELECT * from Websites";
	final String findAllWebsitesById = "SELECT * from Websites where developerId = ?";
	final String findWebsiteById = "SELECT * from Websites where websiteId = ?";
	final String updateWebsite = "UPDATE Websites SET websiteId = ?, developerId = ?, websiteName = ?, description = ?, created = ?, updated = ?, visits = ? where websiteId = ?";
	final String deleteWebsite = "DELETE FROM Websites where websiteId = ?";
	
	final String deleteCnet = "DELETE FROM Websites where websiteName = CNET";
	private WebsiteDao() {
	}
	public static WebsiteDao getInstance() {
		if(instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	public int createWebsiteForDeveloper (int developerId, Website website) {
		int result = -1;
		Connection connection = null;
		
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(createWebsite);
			pstmt.setInt(1, website.getWebsiteId());
			pstmt.setInt(2, developerId);
			pstmt.setString(3, website.getName());
			pstmt.setString(4, website.getDescription());
			pstmt.setDate(5, website.getCreated());
			pstmt.setDate(6, website.getUpdated());
			pstmt.setInt(7, website.getVisits());
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
	
	public ArrayList<Website> findAllWebsites() {
		ArrayList<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(findAllWebsites);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				int websiteId = result.getInt("websiteId");
				int developerId = result.getInt("developerId");
				String name = result.getString("websiteName");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int visits = result.getInt("visits");
				
				Website website = new Website(websiteId, developerId, name, description, created, updated, visits);
				websites.add(website);
			}
			pstmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return websites;
	}
	public ArrayList<Website> findWebsitesForDeveloper(int developerId) {
		ArrayList<Website> websites = new ArrayList<Website>();
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
			psmt = connection.prepareStatement(findAllWebsitesById);
			psmt.setInt(1, developerId);
			ResultSet result = psmt.executeQuery();
			while(result.next()) {
				int websiteId = result.getInt("websiteId");
				int devId = result.getInt("developerId");
				String name = result.getString("websiteName");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int visits = result.getInt("visits");
				
				Website website = new Website(websiteId, devId, name, description, created, updated, visits);
				websites.add(website);
			}
			psmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return websites;
	}
	public Website findWebsiteById(int websiteId) {
		ArrayList<Website> websites = new ArrayList<Website>();
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
			pstmt = connection.prepareStatement(findWebsiteById);
			pstmt.setInt(1, websiteId);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
				int webId = result.getInt("websiteId");
				int devId = result.getInt("developerId");
				String name = result.getString("websiteName");
				String description = result.getString("description");
				Date created = result.getDate("created");
				Date updated = result.getDate("updated");
				int visits = result.getInt("visits");
				Website website = new Website(webId, devId, name, description, created, updated, visits);
				websites.add(website);
			}
			pstmt.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return websites.get(0);
	}
	
	public int updateWebsite(int websiteId, Website website) {
		int result = -1;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstmt = connection.prepareStatement(updateWebsite);
			pstmt.setInt(1, websiteId);
			pstmt.setInt(2, website.getDeveloperId());
			pstmt.setString(3, website.getName());
			pstmt.setString(4, website.getDescription());
			pstmt.setDate(5, website.getCreated());
			pstmt.setDate(6, website.getUpdated());
			pstmt.setInt(7, website.getVisits());
			pstmt.setInt(8, websiteId);
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
	
	public int deleteWebsite(int websiteId) {
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			// Statement for Developer
			PreparedStatement pstDeveloper = connection.prepareStatement(deleteWebsite);
			pstDeveloper.setInt(1, websiteId);
			result = pstDeveloper.executeUpdate();
			pstDeveloper.close();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int deleteCnet() {
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			// Statement for Developer
			PreparedStatement pstDeveloper = connection.prepareStatement(deleteCnet);
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
		WebsiteDao webDao = WebsiteDao.getInstance();
//		Website fb = new Website(1,5,"Facebook", "an online social media and social networking service",new Date(2014, 4, 21), new Date(2010,8,10), 1234234);
//		webDao.createWebsiteForDeveloper(5, fb);
//		Website twitter = new Website(2,6,"Twitter", "an online social media and social networking service",new Date(2011, 3, 11), new Date(2011,4,10), 4321543);
//		Website wiki = new Website(3,7,"Wikipedia", "a free online encyclopedia",new Date(2010, 5, 21), new Date(2016,1,14), 3456654);
//		Website cnn = new Website(4,5,"CNN", "an American basic cable and satellite television news channel",new Date(2010, 5, 21), new Date(2016,1,14), 6543345);
//		Website cnet = new Website(5,2,"CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",new Date(2010, 5, 21), new Date(2016,1,14), 5433455);
		Website gizmodo = new Website(6,2,"Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics",new Date(2011, 7, 14), new Date(2017,2,19), 4322345);
		webDao.createWebsiteForDeveloper(5, gizmodo);
		
//		ArrayList<Website> websites = new ArrayList<Website>();
//		websites = webDao.findAllWebsites();
//		for (Website website : websites) {
//			System.out.println(website.getName());
//		}
		
//		ArrayList<Website> websites = new ArrayList<Website>();
//		websites = webDao.findWebsitesForDeveloper(5);
//		for (Website website : websites) {
//			System.out.println(website.getName());
//		}
//		Website cnnUpdate = new Website(4,5,"CNNUpdated", "an American basic cable and satellite television news channel",new Date(2010, 5, 21), new Date(2016,1,14), 6543345);
//		Website web = webDao.findWebsiteById(3);
//		System.out.println(web.getName());
		
//		Website cnnUpdate = new Website(4,5,"CNNUpdated", "an American basic cable and satellite television news channel",new Date(2010, 5, 21), new Date(2016,1,14), 6543345);
//		webDao.updateWebsite(4,cnnUpdate);
//		ArrayList<Website> websites = new ArrayList<Website>();
//		websites = webDao.findAllWebsites();
//		for (Website website : websites) {
//			System.out.println(website.getName());
//		}
		
//		webDao.deleteWebsite(4);
		
	}
}
