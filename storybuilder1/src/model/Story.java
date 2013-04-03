package model;

import java.util.ArrayList;
import java.util.List;


public class Story 
{
	public String name;
	public List<Page> pages = new ArrayList<Page>();
	public Adult adultUser;
	public List<Child> users = new ArrayList<Child>();
	public Boolean feedback;
	public String backColor = "";
	public String fontName = "";
	public String fontSize = "";
	public String temp = "";
	public int happy, sad, mad, confused, total;
	

	public Story(String name, Adult adultUser) 
	{
		this.name = name;
		this.adultUser = adultUser;
		this.feedback = false;
		this.happy = 0;
		this.sad = 0;
		this.mad = 0;
		this.confused = 0;
		this.total = 0;
	}
	
	public void setColor(String newColor)
	{
		backColor = newColor;
	}
	
	public void setSize(String s)
	{
		fontSize = s;
	}
	
	public void setFeedback(Boolean f)
	{
		this.feedback = f;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}

}

