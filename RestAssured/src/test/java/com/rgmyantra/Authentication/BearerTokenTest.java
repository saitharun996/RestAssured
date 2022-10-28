package com.rgmyantra.Authentication;

import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest 
{
	@Test
	public void barerToken()
	{
		given()
		.auth().oauth2("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")//bearer token iD
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.assertThat().statusCode(200) //basically authentication status code is 202 but here in github it was given as 200
		.log().all();
		
	}

}
