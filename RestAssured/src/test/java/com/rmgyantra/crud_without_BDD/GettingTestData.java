package com.rmgyantra.crud_without_BDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GettingTestData {


		
		@Test
		public void getData()
		{
			Response rsps = RestAssured.get("http://localhost:8084/projects");
		    
			ValidatableResponse vres = rsps.then();
			vres.assertThat().statusCode(200);
			vres.assertThat().contentType(ContentType.JSON);
			vres.log().all();
			
		
			
			
		}

	}


