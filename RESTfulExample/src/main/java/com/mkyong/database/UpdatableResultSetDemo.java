package com.mkyong.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class UpdatableResultSetDemo 
{
	
	public static void update() throws SQLException
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
			System.out.println("came here to update and insert");

				conn = DBUtil.getConnetcion();
				String updateTableSQL = "UPDATE Employee"
						+ " SET firstname = 'sreedhar' "
						+ " WHERE employeeId = 12";
				stmt = (Statement) conn.createStatement();
//				rs = stmt.executeUpdate(updateTableSQL);
				
				stmt.executeUpdate("INSERT INTO Employee " + "VALUES ('sreedhar', 'poupotu', 'hello.', 16)");

	
//			rs.absolute(2);
//			rs.updateString("firstname", "Bhavit");
//			rs.updateRow();
//			System.out.println("record Updated Successfully");
//			
//			rs.moveToInsertRow();
//			rs.updateString("fullname", "Aadit Potu");
//			rs.updateString("firstname", "Aadit");
//			rs.updateString("lastname", "Potu");
//			rs.updateInt("employeeId", 6);
//			rs.insertRow();
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

}
