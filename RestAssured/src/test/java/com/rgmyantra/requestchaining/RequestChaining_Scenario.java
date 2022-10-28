package com.rgmyantra.requestchaining;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rgmyantra.POJO.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining_Scenario 
{
	@Test
	public void reqChaining()
	{
		POJOClass pj=new POJOClass("Saitharu", "SDET_th1", "Created", 12);
		String expectedpro= "SDET_th1";
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
		
		String actualpr=body.jsonPath().get("projectName");
		Assert.assertEquals(expectedpro, actualpr);
		System.out.println("verified");
		
		
		
	}

}
