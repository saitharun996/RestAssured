package com.rmgyantra.crud_with_BDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetProjectTest
{
	@Test
	public void getData()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().statusCode(200)
		.and().assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}

}
