package com.rmgyantra.framework;

import org.testng.annotations.Test;

import com.rgmyantra.POJO.POJOClass;

import genricUtilities.BaseAPIClass;
import genricUtilities.EndPoints;
import genricUtilities.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;

public class Post_Get_End2End_WithUtilities extends BaseAPIClass {

	@Test
	public void CreateProject() throws Throwable
	{
		baseURI="http://localhost";
		port=8084;
		

		POJOClass pj=new POJOClass("saitharun1230", "SAITHARUN"+JavaUtility.generateRandomNumber(), "Created", 12);
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pj)
		.when()
		.post(EndPoints.addPro);
		 
		String proId = response.jsonPath().get("projectId");
		System.out.println(proId);
		
	 Response body = given()
		.pathParam("projectId", proId)
		.when()
		.get(EndPoints.getSingleProject);
	 
	 String ProjectName=body.jsonPath().get("projectName");
	 System.out.println(ProjectName);
	
	  
	  
	 
			//Step 4 Execute Query
	      
	       ResultSet result = dUtil.executeQuery("select project_name from project;");
	        
			

			
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
		
	 
	}


