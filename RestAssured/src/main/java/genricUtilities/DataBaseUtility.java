package genricUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	public Connection con;
	
	public void createConnection() throws Throwable
	{
		Driver dref=new Driver();
		
		DriverManager.registerDriver(dref);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
		
		
	}
	
	public void closeConnection() throws Throwable
	{
		con.close();
	}
	
	public ResultSet executeQuery(String query) throws Throwable
	{
		Statement stat = con.createStatement();
		ResultSet result = stat.executeQuery(query);
		
		return result;
	}

	
	
}
