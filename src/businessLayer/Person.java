package businessLayer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import dataLayer.CustomerConnect;

import dataLayer.CustomerConnect;

public class Person 
{
	private long idPerson;
	private String name;
	private String lastname;
	private String direction;
	private long phon;
	private CustomerConnect connect;
	
	public Person()
	{
		this.idPerson = 0;
		this.name = "";
		this.lastname = "";
		this.direction = "";
		this.phon = 0;
	}
	
	public Person(long id, String nam, String lastnam, String dir, long ph) throws Exception
	{
		if( validateData(id, ph) )
		{
			this.idPerson = id;
			this.name = nam;
			this.lastname = lastnam;
			this.direction = dir;
			this.phon = ph;
		}
	}

	public long getId() 
	{
		return idPerson;
	}

	public void setId(long idPerson) 
	{
		this.idPerson = idPerson;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getLastname() 
	{
		return lastname;
	}

	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}

	public String getDirection() 
	{
		return direction;
	}

	public void setDirection(String direction) 
	{
		this.direction = direction;
	}

	public long getPhon() 
	{
		return phon;
	}

	public void setPhon(long phon) 
	{
		this.phon = phon;
	}
	
	public boolean validateData(long id, long phone)
	{
		if(id >= -1 && phone > -1)
			return true;
		return false;
	}
	
	public void delete(String idPerson) throws SQLException
	{
		connect = new CustomerConnect();
		connect.delet(idPerson);
	}
}
