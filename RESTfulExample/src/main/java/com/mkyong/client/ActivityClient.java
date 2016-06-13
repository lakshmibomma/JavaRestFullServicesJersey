package com.mkyong.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class ActivityClient {

	private Client client;
	
	public ActivityClient()
	{
		client = ClientBuilder.newClient();
	}
}
