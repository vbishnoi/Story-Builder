package model;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Page 
{
	public String text;
	public List<String> img = new ArrayList<String>();
	public Color background;
	public String sound;

	public Page(String text) 
	{
		this.text = text;
		this.background = Color.WHITE;
		this.sound = "";
	}
	
	public void setSound(String url)
	{
		sound = url;
	}
	
	@Override
	public String toString()
	{
		return this.text;
	}

}

