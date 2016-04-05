package businessLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import dataLayer.CustomerConnect;

public class Customer extends Person {
	private CustomerConnect connect;
	
	public Customer()
	{
		super();
	}
	
	public Customer(long id, String nam, String lastnam, String dir, long phon) throws Exception
	{
		super (id, nam, lastnam, dir, phon);
	}
	
	public ArrayList<Customer> consult() throws Exception
	{
		connect = new CustomerConnect();
		ArrayList<Customer> list = connect.consult();
		return list;
	}
		
	public void save() throws SQLException
	{
		connect = new CustomerConnect();
		connect.save(this.getId(), this.getName(), this.getLastname(), this.getDirection(), this.getPhon());
	}

}
