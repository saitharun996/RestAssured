package com.rgmyantra.requestchaining;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rgmyantra.POJO.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining_post_delete 
{
	@Test()
	public void requestChaining()
	{
     POJOClass pj=new POJOClass("Saitharun", "AsaamProject1111", "created", 24);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pj)
		.when()
		.post("http://localhost:8084/addProject");
		
		
		String proId = response.jsonPath().get("projectId");
		given()
		.pathParam("projectId", proId)
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then()
		.log().all();
		
		
		
		
		
	
		
	}
	
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] objArr=new Object[1][4];
		
		objArr[0][0]="Puppy1294";
		objArr[0][1]="RJNR_HOME2";
		objArr[0][2]="Created";
		objArr[0][3]=4;
		return objArr;

}
}
