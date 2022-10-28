package com.rgmyantra.requestchaining;

import org.testng.annotations.Test;

import com.rgmyantra.POJO.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining_Scenario2 
{
	@Test
	public void reqchain()
	{
		POJOClass pj=new POJOClass("saitharun", "tarun1", "created", 13);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pj)
		.when()
		.post("http://localhost:8084/addProject");
		
		
		
		POJOClass pj1=new POJOClass("sai", "tarunnnn", "onGoing", 13);
		String proId1 = response.jsonPath().get("projectId");
		
		    Response resp1 = given()
				.contentType(ContentType.JSON)
				.pathParam("projectId", proId1)
				.body(pj1)
				.when()
				.put("http://localhost:8084/projects/{projectId}");
		    
		    String proId2 = resp1.jsonPath().get("projectId");
		    
		given()
		.pathParam("projectId", proId2)
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then()
		.log()
		.all();
		
	
		
	}

}
