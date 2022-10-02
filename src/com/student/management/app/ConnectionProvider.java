package com.student.management.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	static Connection con;
	
	public static Connection createConnection() {
		
		try {
			
			//steps of creating Database connection...
			
			//1. load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Create the connection...
			String url = "jdbc:mysql://localhost:3306/student_management_app";
			String username = "root";
			String password = "wasim";
			con = DriverManager.getConnection(url, username, password);
			
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//return the connection
		return con;
		
		
		
	}
}
