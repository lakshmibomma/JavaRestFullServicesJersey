package com.mkyong.database;


public class DatabaseInstance {
	
	public static void createDatabaseInstance()
	{
		System.out.println("Databse Instance created method came here");

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
		 System.out.println("Databse Instance created");

	}

	
}
