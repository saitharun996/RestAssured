package com.rmgyantra.crud_without_BDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeletingData 
{
	@Test
	public void deleteData()
	{
		Response rsps = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_402");
		
		int status = rsps.getStatusCode();
		
		System.out.println(status);
		
		Assert.assertEquals(status, 204);
		
	}
	

}
