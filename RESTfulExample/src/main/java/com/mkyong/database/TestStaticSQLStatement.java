package com.mkyong.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class TestStaticSQLStatement {
 
	public static void main(String[] args) throws SQLException
	{		
		Connection conn = null;
		Statement stmt  =  null;
		ResultSet rs = null;
		try
		{
			System.out.println("came here to select");
			conn = DBUtil.getConnetcion();
			stmt  = conn.createStatement();
			rs = stmt.executeQuery("select *from Employee");
			rs.last();
			System.out.println("Total Rows:"+rs.getRow());
			
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
