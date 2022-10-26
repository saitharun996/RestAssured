package com.rmgyantra.crud_DIfferent_ways_to_post_request;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreatingProjectUsingJSONFileTest 
{
	@Test
	public void createProject()
	{
		File f=new File("./RGM_YANTRA.json");
		
	  given()
	  .contentType(ContentType.JSON)
	  .body(f)
	  .when()
	  .post("http://localhost:8084/addProject")
	  .then()
	  .log().all();
	}

}
