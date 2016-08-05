package com.mkyong.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mkyong.model.Activity;
import com.mkyong.model.ActivitySearch;
import com.mkyong.model.User;
import com.mkyong.database.DBUtil;

public class ActivityRepositoryStub implements ActivityRepository 
{	
	
	public List<Activity> findByConstraints(ActivitySearch search) {
		//select *from activities where description in (?,?,?) and duration >? and duration <?
		System.out.println(search.getDurationFrom());
		System.out.println(search.getSearchType());

		List<Activity> activities = new ArrayList<Activity>();
				
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		activity1.setId("2345");
		activities.add(activity1);
				
		return activities;
	}
	
	public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo)
	{

		//select *from activities where description in (?,?,?) and duration >? and duration <?
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		activity1.setId("2345");
		activities.add(activity1);
		
		return activities;
	}
	
	public void delete(String activityId) {
		//delete from activity where activityId = ""
	}
	
	public Activity update(Activity activity)
	{		
		//Search the database to see if we have an activity with that id already exists
		//select *from Activity where id =?
		//if rs size ==0
		//insert into Activity table
		//else
		//update the Activity
		
		return activity;
		
		
	}
	public void create(Activity activity)
	{
		//Should issue a insert statement to the Database
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.mkyong.repository.ActivityRepository#findAllActivities()
	 */
	public List<Activity> findAllActivities()
	{
		List<Activity> activities = new ArrayList<Activity>();
		
		Activity activity1 = new Activity();
		activity1.setDescription("Running");
		activity1.setDuration(55);
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity2.setDescription("Swimming");
		activity2.setDuration(30);
		activities.add(activity2);
		
		
		return activities;
		
	}
	public Activity findActivity(String activityId) {
		 if (activityId.equals("7777"))
		 {
			 return null;
		 }
		Activity activity1 = new Activity();
		activity1.setDescription("Shopping");
		activity1.setDuration(55);
		activity1.setId("1234");
		
		User user = new User();
		user.setName("Lakshmi");
		user.setId("5678");
		activity1.setUser(user);
		return activity1;
	}

	public String setupDatabseConnection() throws SQLException {
		// TODO Auto-generated method stub
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		final String dbUrl = "jdbc:mysql://localhost:8889/JavaOne";
	    final String username = "root";
	    final String password = "root";

		System.out.println("Welcome to Jva Platform:Working with Databses using JDBC");
//		Connection conn = DriverManager.getConnection(dbUrl, username, password);
		
		Connection conn = DBUtil.getConnetcion();

		System.out.println("Connection to mysql databse established successfylly");
		
		Statement stmt = conn.createStatement();  
		  
		ResultSet rs = stmt.executeQuery("select * from Employee");  
//		String row = rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3);

		while(rs.next())  
		
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		
		  
		conn.close();  
		return  "Connection to mysql databse established successfylly";
	}

	
	

}
