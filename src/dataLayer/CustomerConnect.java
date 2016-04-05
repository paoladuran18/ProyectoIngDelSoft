package dataLayer;
import java.sql.*;
import java.util.ArrayList;

import businessLayer.Customer;
import businessLayer.Person;

public class CustomerConnect 
{
	private ConnectorDB connection;
	private PreparedStatement paInsert;
	private Connection connector;
	private Statement st;
	private ResultSet rs;
	
	public void save(long id, String name, String lastnam, String dir, long phone) throws SQLException
	{
		connector = connection.getConnection();
	
			paInsert = connector.prepareStatement("INSERT INTO cliente (idCliente, nombre, apellido, direccion, "
					+ "telefono) VALUES (?,?,?,?,?)");
			
			paInsert.setLong(1, id);
			paInsert.setString(2, name);
			paInsert.setString(3, lastnam);
			paInsert.setString(4, dir);
			paInsert.setLong(5, phone);
			paInsert.executeUpdate();
			connection.close();
			connector.close();
	
	}
	
	public ArrayList<Customer> consult () throws Exception
	{
		Connection t = connection.getConnection();
		Customer person;
		ArrayList<Customer> perList = new ArrayList();
		
		Statement st1 = t.createStatement();
		rs = st1.executeQuery("SELECT * FROM cliente");
		
		while(rs.next())
			perList.add(person = new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), 
					rs.getString(4), rs.getLong(5)));
		st1.close();
		rs.close();
			
		return perList;
	}
}
