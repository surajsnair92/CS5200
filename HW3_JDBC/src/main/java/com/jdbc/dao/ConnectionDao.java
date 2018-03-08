package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConnectionDao {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String databaseURL = "jdbc:mysql://cs5200-spring2018-nair.cvplzbt0w7bd.us-east-2.rds.amazonaws.com/hw2_nair_suraj_spring_2018";
	final String username = "suraj";
	final String password = "nair1234";
    Connection conn = null;
    PreparedStatement pstmt = null;

}
