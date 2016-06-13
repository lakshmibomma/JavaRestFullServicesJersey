package com.mkyong.repository;

import java.util.ArrayList;
import java.util.List;

import com.mkyong.model.Activity;
import com.mkyong.model.User;

public class ActivityRepositoryStub implements ActivityRepository 
{
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
		activity1.setDescription("Shopping");
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
	
	

}
