package model;


public class Adult 
{
	public String name, password;
	boolean havePassword;

	
	public Adult(final String newName, final String newPassword)
	{
		this.name = newName;
		this.password = newPassword;
	}
	
	public final void setName(String newName)
	{
		this.name = newName;
	}
	
	public final String getName()
	{
		return name;
	}
	
	public final void setPassword(String newPassword)
	{
		this.password = newPassword;
	}
	
	public final String getPassword()
	{
		return password;
	}

}
