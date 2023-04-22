package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
static Connection con;

	
	public DBUtil() {
		
	}
	
	public static Connection getCon() {
		Connection con=null;
		String url="jdbc:oracle:thin:@DESKTOP-0GI8HTS:1521:XE";//
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//load the driver
			System.out.println("Driver loaded");
			
			 con=DriverManager.getConnection(url,"hr","hr");
			System.out.println("Connection "+con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}

}
