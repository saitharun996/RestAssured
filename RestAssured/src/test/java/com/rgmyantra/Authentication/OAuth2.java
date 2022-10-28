package com.rgmyantra.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2
{
	@Test
	public void Oauth()
	{
		Response rsps = given()
		.formParam("client_id", "Tharun")
		.formParam("client_secret", "9af842d144ae05d2e9caa2f3ba3af18b")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://example.com")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		//.then().log().all();
		
		String token = rsps.jsonPath().get("access_token");
		System.out.println(token);
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", "3966")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then()
		.log()
		.all();
		
		
		
		
		
	}

}
