package com.mkyong.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class UpdateandInsertQuery 
{
	public static void insert() throws SQLException
	{
		Connection conn = null;
		Statement stmt  =  null;
		ResultSet rs = null;

		try
		{
			System.out.println("came here to insert");
			conn = DBUtil.getConnetcion();
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate("INSERT INTO Employee " + "VALUES ('Bhavit', 'poupotu', 'hello.', 16)");
			System.out.println("record insert Successfully");
			
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
	
	public static void update() throws SQLException
	{
		Connection conn = null;
		Statement stmt  =  null;
		ResultSet rs = null;
		
		try
		{
			System.out.println("came here to update");
			conn = DBUtil.getConnetcion();
			String sql = 
						   "UPDATE Employee " + 
						   "  SET lastname = ? " + 
						   "WHERE fullname = ?";
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, "potu");
			pstmt.setString(2, "Bhavit");
			pstmt.executeUpdate();
			System.out.println("record updated Successfully");
			
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
