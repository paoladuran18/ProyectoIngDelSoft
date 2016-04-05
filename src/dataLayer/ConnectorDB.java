package dataLayer;
import java.sql.*;

public class ConnectorDB 
{
	
	private static Connection connector = null;
	
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connector = DriverManager.getConnection("jdbc:mysql://localhost/ventasyfacturacion", "root", "18061992merida");
		} catch (ClassNotFoundException | SQLException ex) {}
		return connector;
	}
	
	public static void close() throws SQLException 
	{
		if (connector != null)
			connector.close();
	}
	
}
