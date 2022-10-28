package genricUtilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {
	
	public DataBaseUtility dUtil=new DataBaseUtility();
	
	@BeforeSuite
	public void createConn() throws Throwable
	{
		dUtil.createConnection();
	}
	
	@AfterSuite
	public void closeCon() throws Throwable
	{
		dUtil.closeConnection();
	}

}
