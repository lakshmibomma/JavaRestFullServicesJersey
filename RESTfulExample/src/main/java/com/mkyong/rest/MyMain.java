package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class MyMain {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Hello World : " + msg;
		return Response.status(200).entity(output).build();
	}
	
	/*Simple get method*/
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt()
	{
		return "Go Here";
	}
	
	/*get method with 1 parameter*/
	@GET
	@Path("/getValue/{param}")
	public String getTheValue(@PathParam("param") String msg)
	{
		return "Hello "+ msg;
	}
	
	/*get method with 2 parameters*/
	@GET
	@Path("/getStringConcat/{param1}/{param2}")
	public Response strinConcat(@PathParam("param1") String msg1,@PathParam("param2") String msg2)
	{
		String output  = "Hello "+ msg1 + msg2;
		return Response.status(200).entity(output).build();
	}
}
