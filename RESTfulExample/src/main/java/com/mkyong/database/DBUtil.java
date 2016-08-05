package com.mkyong.database;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBUtil
{
	private static final String mySqlUser = "root";
	private static final String mySqlPassword = "root";
	private static final String mySqlUrl = "jdbc:mysql://localhost:8889/JavaOne";
	
   public static Connection getConnetcion() throws SQLException 
   {
		System.out.println("Databse created");
	   return (Connection) DriverManager.getConnection(mySqlUrl, mySqlUser, mySqlPassword);
   }
	

}
