package com.rmgyantra.parameters;

import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter
{
	@Test
	public void pathParameter()
	{
	  given()
	  .pathParam("proId", "TY_PROJ_004")
	  .when()
	  .delete("http://localhost:8084/projects/{proId}")
	  .then()
	  .assertThat().statusCode(204)
	  .log().all();
	}

}
