package com.rmgyantra.parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameter
{
  @Test
  public void queryPara()
  {
	  given()
	  .pathParam("username", "saitharun996")
	  .queryParam("sort", "created")
	  .when()
	  .get("https://api.github.com/user/{username}/repos")
	  .then()
	  .log().all();
  }

}
