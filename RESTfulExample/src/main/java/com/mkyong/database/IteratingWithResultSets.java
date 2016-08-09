package com.mkyong.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class IteratingWithResultSets {
	
	   public static void getTableResults() throws SQLException 
	   {
	
		Connection conn = null;
		Statement stmt  =  null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			conn = DBUtil.getConnetcion();
			stmt  = conn.createStatement();
			rs = stmt.executeQuery("select *from Employee");
			
			while (rs.next())
			{
			    System.out.println("main method of IteratingWithResultSets class called");
				System.out.println("fullname"+ rs.getString("fullname")+"  "+rs.getString("firstname")+"  "+rs.getString("lastname")+"  "+rs.getString("employeeId"));  

			}
			
		}catch(SQLException ex)
		{
			DBUtil.showErrorMessage(ex);
		}
		finally
		{
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		
	}
}
