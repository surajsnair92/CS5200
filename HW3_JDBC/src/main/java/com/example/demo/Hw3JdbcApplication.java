package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw3JdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw3JdbcApplication.class, args);
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://cs5200-spring2018-nair.cvplzbt0w7bd.us-east-2.rds.amazonaws.com/hw2_nair_suraj_spring_2018", "suraj","nair1234");
			String selectStat = "SELECT * FROM Employee";
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(selectStat);
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
