package com.rmgyantra.crud_DIfferent_ways_to_post_request;

import org.testng.annotations.Test;

import com.rgmyantra.POJO.POJOClass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingProjectUsing_POJOClassTest
{
	@Test
	public void creatingProject()
	{
		POJOClass pj=new POJOClass("Saitharun", "SDET-93456987", "On-going", 24);
		
		given()
		.contentType(ContentType.JSON)
		.body(pj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all();
	}

}
