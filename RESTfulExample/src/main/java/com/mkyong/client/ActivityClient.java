package com.mkyong.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mkyong.model.Activity;

public class ActivityClient {

	private Client client;
	
	public ActivityClient()
	{
		client = ClientBuilder.newClient();
		System.out.println(client);

	}
	
	public Activity get(String id)
	{
		
		WebTarget target = client.target("http://localhost:8080/TestJava/rest/");
		System.out.println(target);

		Response response = target.path("activities/"+id).request().get(Response.class);
		System.out.println(response);
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus()+":there was an error on the server");
		}
		return (Activity) response.getEntity();

//		return ((Object) response).readEntity(Activity.class);
		
	}
	
	
	public Activity create(Activity activity)
	{
		
		WebTarget target = client.target("http://localhost:8080/TestJava/rest/");
		System.out.println(target);

		Response response = target.path("activities/activity").request(MediaType.APPLICATION_JSON).post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		System.out.println(response);
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus()+":there was an error on the server");
		}
		return (Activity) response.getEntity();

//		return ((Object) response).readEntity(Activity.class);
		
	}
	
	public Activity update(Activity activity)
	{
		
		WebTarget target = client.target("http://localhost:8080/TestJava/rest/");
		System.out.println(target);

		Response response = target.path("activities/"+activity.getId()).request(MediaType.APPLICATION_JSON).put(Entity.entity(activity, MediaType.APPLICATION_JSON));
		System.out.println(response);
		if(response.getStatus() != 200)
		{
			throw new RuntimeException(response.getStatus()+":there was an error on the server");
		}
		return (Activity) response.getEntity();

//		return ((Object) response).readEntity(Activity.class);
		
	}
}
