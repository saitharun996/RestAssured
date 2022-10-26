package com.rgmyantra.requestchaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining {
	@Test
	public void requestChain()
	{
	  Response rsps = when()
	  .get("http://localhost:8084/projects");
	  
	  String proId=rsps.jsonPath().get("[1].projectId");
	  System.out.println(proId);
	  
	  given()
	  .pathParam("projectid", proId)
	  .when()
	  .delete("http://localhost:8084/projects/{projectid}")
	  .then()
	  .log().all();
	}

}
