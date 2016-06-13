package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.mkyong.model.Activity;
import com.mkyong.model.User;
import com.mkyong.repository.ActivityRepository;
import com.mkyong.repository.ActivityRepositoryStub;

@Path("activities") //http://localhost:8080/TestJava/rest/activities
public class ActivityResource
{
	private ActivityRepository activityRepository =  new ActivityRepositoryStub();
	
	@POST
	@Path("activity") //http://localhost:8080/TestJava/rest/activities/activity
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
	
	public Activity createActivity(Activity activity)
	{
		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());

		activityRepository.create(activity);//This is for storing in Data base

		return activity;
	}

	
	//Post Activities
	@POST
	@Path("activity") //http://localhost:8080/TestJava/rest/activities/activity
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON}) 
	public Activity createActivityParams(MultivaluedMap<String, String> formParams)
	{
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		
		Activity activity = new Activity();
		activity.setDescription(formParams.getFirst("description"));
		String durationValue = formParams.getFirst("duration");
		
		activity.setDuration(Integer.parseInt(durationValue));
		
		activityRepository.create(activity);//This is for storing in Data base
		return activity;//Just for testing without DB
		
	}
	

	//Get all activities
	// Sending 2 headers both xml and json--test in postman chrome--see the xml and json output
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) 
	public List<Activity> getAllActivities()
	{
		return activityRepository.findAllActivities();
	}

	//Get specific activity
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	
	@Path("{activityId}") //http://localhost:8080/TestJava/rest/activities/activityId
	public Activity getActivity(@PathParam("activityId") String activityId)  ////http://localhost:8080/TestJava/rest/activities/1234
	{
		return activityRepository.findActivity(activityId);
	}
	
	//Get specific user
		@GET
		@Produces({MediaType.APPLICATION_JSON})
		@Path("{activityId}/user") //http://localhost:8080/TestJava/rest/activities/activityId/user
		public User getActivityUser(@PathParam("activityId") String activityId)  ////http://localhost:8080/TestJava/rest/activities/1234/user
		{
			
//			Activity activity = activityRepository.findActivity(activityId);
//			User user  = activity.getUser();
//			return user;
			
			return activityRepository.findActivity(activityId).getUser();
		}
}
