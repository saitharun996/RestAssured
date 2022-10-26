package com.rmgyantra_validation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class dynamicValidationTest 
{
	@Test
	public void dynamicValidation()
	{
		
		String expProName="deepak_pro-5";
		
		        Response rsps = when()
				.get("http://localhost:8084/projects");
		        
		        List<String> actProList = rsps.jsonPath().get("projectName");
		        int count=actProList.size();
		        
		        for (int i = 0; i < count; i++) 
		        {
		        	String actProName=actProList.get(i);
		        	if (expProName.equals(actProName)) 
		        	{
		        		System.out.println(expProName+" is available");
		        		break;
						
					}
					
				}
		
		
		
		
		
		
	}

}
