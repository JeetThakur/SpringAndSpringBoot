package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		// The db url
		String jdbcurl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		
		// The db user and password
		String user = "hbstudent";
		String pass = "hbstudent";
		try{
			System.out.println("Connecting to Database: " + jdbcurl);
			
			Connection myConn = DriverManager.getConnection(jdbcurl, user, pass);
			
			System.out.println("Success !!!!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
