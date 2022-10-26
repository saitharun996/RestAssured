package com.rmgyantra.crud_without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PostingTheData 
{
	
	@Test
	public void createProject()
	{
		JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy", "Sai_Tharun");
		jobj.put("projectName", "SDET_02499999");
		jobj.put("status", "created");
		jobj.put("teamSize", "16");
		
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jobj);
		
		Response rsps = reqSpec.post("http://localhost:8084/addProject");
		
		ValidatableResponse vres = rsps.then();
		vres.assertThat().statusCode(201);
		vres.log().all();
		
		
	}

}
