package com.rmgyantra_validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class staticValidationTest
{
	@Test
	public void staticValidation()
	{
		String expProName="deepak_pro-3";
		
	   Response rsps = when()
	    .get("http://localhost:8084/projects");
	   
	  String actProName = rsps.jsonPath().get("[1].projectName");
	  System.out.println(actProName);
	  
	  Assert.assertEquals(actProName, expProName);
	}

}
