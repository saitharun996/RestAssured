package com.rgmyantra.requestchaining;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rgmyantra.POJO.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining_post_delete 
{
	@Test(dataProvider="provideData")
	public void requestChaining(String createdBy, String projectName, String status, int teamSize )
	{
     POJOClass pj=new POJOClass(createdBy, projectName, status, teamSize);
		
		Response response = given()
		.contentType(ContentType.JSON)
		.body(pj)
		.when()
		.post("http://localhost:8084/addProject");
		
		response.jsonPath().g
		
	
		
	}
	
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] objArr=new Object[1][4];
		
		objArr[0][0]="Puppy1294";
		objArr[0][1]="RJNR_HOME1";
		objArr[0][2]="Created";
		objArr[0][3]=4;
		return objArr;

}
}
