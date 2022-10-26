package com.rmgyantra.crud_with_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostingTheData 
{
	@Test
	public void createProject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Tharun");
		jobj.put("projectName", "SDET_324076899");
		jobj.put("status", "Created");
		jobj.put("teamSize", "16");
		
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}

}
