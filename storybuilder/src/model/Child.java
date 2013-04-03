package model;


public class Child 
{

	public String name, password, picUrl;

	public Child(String newName, String newPassword, String newPic) 
	{
		this.name = newName;
		this.password = newPassword;
		this.picUrl = newPic;
	}
	
	public final void setName(String newName)
	{
		this.name = newName;
	}
	
	public final String getName()
	{
		return name;
	}
	
	public final void setPic(String newPicLoc)
	{
		this.picUrl = newPicLoc;
	}
	
	public final String getPic()
	{
		return picUrl;
	}

}
