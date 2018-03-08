package com.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.models.Developer;

public class DeveloperDao extends ConnectionDao {
	private static DeveloperDao instance = null; 
	final String createDeveloper = 
			"INSERT INTO Developers (developerId, developerKey, personId) VALUES (?, ?, ?)";
	final String createPerson = 
			"INSERT INTO Persons (personId, firstName, lastName, username, password, dob, email) "
					+ "VALUES (?, ?, ?, ?, ?,?,?)";
	final String findAllDevelopers = "SELECT * FROM Developers d JOIN Persons p on d.personId = p.personId";
	final String findDeveloperById = "SELECT * FROM Developers d JOIN Persons p on d.personId = p.personId where d.developerId = ?";
	final String findDeveloperbyUsername = "SELECT * FROM Developers d JOIN Persons p on d.personId = p.personId where p.username = ?";
	final String findDeveloperByCredentials = "SELECT * FROM Developers d JOIN Persons p on d.personId = p.personId where p.username = ? and p.password = ?";
	final String updateDeveloper = "UPDATE Developers SET developerKey = ? WHERE developerId = ?";
	final String updatePerson = "UPDATE Persons SET personId = ?, firstName = ?, lastName = ?, username = ?, password = ?, dob = ?, email = ? WHERE personId = ?";
	final String deleteDeveloper = "DELETE d, p from Developers d INNER JOIN Persons p on p.personId = d.personId where d.developerId = ?";
	
	final String updatePhone = "UPDATE Phone set phone = ? where personId = ? and primary = ?";
	final String deleteAddress = "DELETE FROM Address where personId = ? and primaryAddress = ?";
	private DeveloperDao() {}

	public static DeveloperDao getInstance() {
		if(instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}
	public int createDeveloper(Developer developer) {
		int result = -1;
		Connection connection = null;
		PreparedStatement pstDeveloper = null;
		PreparedStatement pstPerson = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstPerson = connection.prepareStatement(createPerson);
			pstPerson.setInt(1, developer.getPersonId());
			pstPerson.setString(2, developer.getFirstName());
			pstPerson.setString(3, developer.getLastName());
			pstPerson.setString(4, developer.getUsername());
			pstPerson.setString(5, developer.getPassword());
			pstPerson.setDate(6, developer.getDob());
			pstPerson.setString(7, developer.getEmailId());

			pstPerson.executeUpdate();

			pstDeveloper = connection.prepareStatement(createDeveloper);
			pstDeveloper.setInt(1, developer.getDeveloperId());
			pstDeveloper.setString(2, developer.getDeveloperKey());
			pstDeveloper.setInt(3, developer.getPersonId());
			result = pstDeveloper.executeUpdate();
			pstDeveloper.close();


			pstPerson.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Developer> findAllDevelopers() {
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-nair.cvplzbt0w7bd.us-east-2.rds.amazonaws.com/hw2_nair_suraj_spring_2018";
		final String USERNAME = "suraj";
		final String PASSWORD = "nair1234";
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			statement = connection.prepareStatement(findAllDevelopers);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int developerId = result.getInt("developerId");
				String developerKey = result.getString("developerKey");
				int personId = result.getInt("personId");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String username = result.getString("username");
				String password = result.getString("password");
				String emailId = result.getString("email");
				Date dob = result.getDate("dob");

				Developer developer = new Developer(personId, firstName, lastName, username, password,dob, emailId, developerId, developerKey);
				developers.add(developer);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return developers;
	}

	public Developer findDeveloperById(int developerId) {
		Connection connection = null;
		PreparedStatement statement = null;
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://cs5200-spring2018-nair.cvplzbt0w7bd.us-east-2.rds.amazonaws.com/hw2_nair_suraj_spring_2018";
		final String USERNAME = "suraj";
		final String PASSWORD = "nair1234";
		Developer developer = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			statement = connection.prepareStatement(findDeveloperById);
			statement.setInt(1, developerId);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int devId = result.getInt("developerId");
				String developerKey = result.getString("developerKey");
				int personId = result.getInt("personId");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String username = result.getString("username");
				String password = result.getString("password");
				String emailId = result.getString("email");
				Date dob = result.getDate("dob");

				developer = new Developer(personId,firstName, lastName,  username, password,dob, emailId, devId, developerKey);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return developer;
	}

	public Developer findDeveloperByUsername(String userName) {
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			statement = connection.prepareStatement(findDeveloperbyUsername);
			statement.setString(1, userName);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int devId = result.getInt("developerId");
				String developerKey = result.getString("developerKey");
				int personId = result.getInt("personId");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String username = result.getString("username");
				String password = result.getString("password");
				String emailId = result.getString("email");
				Date dob = result.getDate("dob");
				Developer developer = new Developer(personId,firstName, lastName,  username, password,dob, emailId, devId, developerKey);
				developers.add(developer);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return developers.get(0);
	}

	public Developer findDeveloperByCredentials(String username, String password) {
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			statement = connection.prepareStatement(findDeveloperByCredentials);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int devId = result.getInt("developerId");
				String developerKey = result.getString("developerKey");
				int personId = result.getInt("personId");
				String firstName = result.getString("firstName");
				String lastName = result.getString("lastName");
				String user = result.getString("username");
				String pass = result.getString("password");
				String emailId = result.getString("email");
				Date dob = result.getDate("dob");
				Developer developer = new Developer(personId,firstName, lastName,  user, pass,dob, emailId, devId, developerKey);
				developers.add(developer);
			}
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return developers.get(0);
	}

	public int updateDeveloper(int developerId, Developer developer) {
		int result = -1;

		Connection connection = null;
		PreparedStatement statement = null;
		PreparedStatement pstPerson = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			statement = connection.prepareStatement(updateDeveloper);
			pstPerson = connection.prepareStatement(updatePerson);
			pstPerson.setInt(1, developer.getPersonId());
			pstPerson.setString(2, developer.getFirstName());
			pstPerson.setString(3, developer.getLastName());
			pstPerson.setString(4, developer.getUsername());
			pstPerson.setString(5, developer.getPassword());
			pstPerson.setDate(6, developer.getDob());
			pstPerson.setString(7, developer.getEmailId());
			pstPerson.setInt(8, developer.getPersonId());
			pstPerson.executeUpdate();
			statement.setString(1, developer.getDeveloperKey());
			statement.setInt(2, developerId);
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
	public int deleteDeveloper(int developerId) {
		int result = -1;

		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			// Statement for Developer
			PreparedStatement pstDeveloper = connection.prepareStatement(deleteDeveloper);
			pstDeveloper.setInt(1, developerId);
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
	
	// Update Charlie's phone Number.
	// Tests:
		// devDao.updatePhone("333-444-5555", 3, true)
	public int updatePhone(String phone, int personId, boolean primary) {
		int result = -1;
		Connection connection = null;
		PreparedStatement pstPerson = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(databaseURL, username, password);
			pstPerson = connection.prepareStatement(updatePhone);
			pstPerson.setString(1, phone);
			pstPerson.setInt(2, personId);
			pstPerson.setBoolean(3, primary);
			pstPerson.executeUpdate();
			result = pstPerson.executeUpdate();
			pstPerson.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	// delete address. 
	public int deleteAddress(int personId, boolean primaryAddress ) {
		int result = -1;
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(databaseURL, username, password);
			// Statement for Developer
			PreparedStatement pstDeveloper = connection.prepareStatement(deleteAddress);
			pstDeveloper.setInt(1, personId);
			pstDeveloper.setBoolean(2, primaryAddress);
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
		DeveloperDao devDao = DeveloperDao.getInstance();

		//		Developer ron = new Developer(7,"Cristiano","Ronaldo", "cr", "seven",new Date(1983, 04, 18),"ron@cr7.com",7,"cr7");
		//		Developer ney = new Developer(14,"Neymar","Jr", "ney", "jr",new Date(1992, 10, 28),"ney@psg.com",14,"ney14");
		//		Developer eden = new Developer(17,"Eden","Hazard", "eden", "hazard",new Date(1992, 8, 11),"eden@blues.com",4,"hazard17");
		//		devDao.createDeveloper(eden);
		Developer alice = new Developer(1,"Alice","Wonder", "alice", "alice",new Date(1992, 8, 11),"alice@wonder.com",5,"4321rewq");
		Developer bob = new Developer(2,"Bob","Marley", "bob", "bob",new Date(1992, 8, 11), "bob@marley.com",6,"5432trew");
		Developer charlie = new Developer(3,"Charlie","Garcia", "charlie", "charlie",new Date(1992, 8, 11), "chuch@garcia.com",7,"6543ytre");
		Developer dan = new Developer(4,"Dan","Martin", "dan", "dan",new Date(1992, 8, 11), "dan@martin.com",8,"7654fda");
		Developer ed = new Developer(5,"Ed","Karaz", "ed", "ed",new Date(1992, 8, 11), "ed@kar.com",9,"5678dfgh");
		devDao.createDeveloper(alice);
		devDao.createDeveloper(bob);
		devDao.createDeveloper(charlie);
		devDao.createDeveloper(dan);
		devDao.createDeveloper(ed);

		//		ArrayList<Developer> developers = devDao.findAllDevelopers();
		//		for (Developer developer : developers) {
		//			System.out.println(developer.getUsername());
		//		}
		//		Developer d = devDao.findDeveloperByUsername("leo");
		//		System.out.println(d.getLastName());

		//		Developer messiUpdate = new Developer(10,"Leo","Messi", "leo", "leo",new Date(1980, 10, 02),"leo@barca.com",10,"leo10");
		//		devDao.updateDeveloper(10,messiUpdate);
		//		
		//		Developer d = devDao.findDeveloperByCredentials("leo","leo");
		//		System.out.println(d.getEmailId());

		//		int d = devDao.deleteDeveloper(4);

	}
}
