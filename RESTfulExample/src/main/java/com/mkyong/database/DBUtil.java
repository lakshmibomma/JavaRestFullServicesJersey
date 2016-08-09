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
	   DatabaseInstance.createDatabaseInstance();

	   System.out.println("Databse created");
	   return (Connection) DriverManager.getConnection(mySqlUrl, mySqlUser, mySqlPassword);
   }
	
   public static void showErrorMessage(SQLException e)
   {
	   System.err.println("Error:" + e.getMessage());
	   System.err.println("Error Code :" + e.getErrorCode());
   }
}
