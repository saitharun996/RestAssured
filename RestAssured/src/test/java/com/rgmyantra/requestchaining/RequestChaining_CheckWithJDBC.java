package com.rgmyantra.requestchaining;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.rgmyantra.POJO.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class RequestChaining_CheckWithJDBC 
{
	@Test
	public void reqchain() throws Throwable
	{
		POJOClass pj=new POJOClass("saitharun1230", "TEDS_SSSSS221", "Created", 12);
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pj)
		.when()
		.post("http://localhost:8084/addProject");
		 
		String proId = response.jsonPath().get("projectId");
		System.out.println(proId);
		
	 Response body = given()
		.pathParam("projectId", proId)
		.when()
		.get("http://localhost:8084/projects/{projectId}");
	 
	 String ProjectName=body.jsonPath().get("projectName");
	 System.out.println(ProjectName);
	 Connection con=null;
		try {
			//Step-1 Register the driver
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			
			// Step 3 create Statement
			Statement stat=con.createStatement();
			
			//Step 4 Execute Query
			ResultSet result=stat.executeQuery("select project_name from project;");

			
			String actualprojectname=ProjectName;
			
			while(result.next())
			{
				
				if(actualprojectname.equals(result.getString(1)))
				{
					System.out.println("Validation Successfull");
					break;
				
				
				
			}
		
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Step 5 close connection with Database
		}
			finally {
				
			con.close();
		System.out.println("Connection closed");
			}

		
		
	
	
	
		


}
}
