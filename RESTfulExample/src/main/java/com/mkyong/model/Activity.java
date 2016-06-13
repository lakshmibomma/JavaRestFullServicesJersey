package com.mkyong.model;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement
public class Activity 
{
	private String description;
	private String id;
	private User user;
	private int duration;
	
	@XmlElement(name="desc")
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public int getDuration()
	{
		return duration;
	}
	public void setDuration(int duration)
	{
		this.duration = duration;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
