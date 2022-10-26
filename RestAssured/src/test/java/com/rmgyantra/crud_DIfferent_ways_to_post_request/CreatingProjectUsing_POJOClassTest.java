package com.rmgyantra.crud_DIfferent_ways_to_post_request;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rgmyantra.POJO.POJOClass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingProjectUsing_POJOClassTest
{
	@Test(dataProvider="provideData")
	public void creatingProject(String createdBy, String projectName, String status, int teamSize )
	{
		POJOClass pj=new POJOClass(createdBy, projectName, status, teamSize);
		
		given()
		.contentType(ContentType.JSON)
		.body(pj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all();
	}
	
	@DataProvider
	public Object[][] provideData()
	{
		Object[][] objArr=new Object[2][4];
		
		objArr[0][0]="Puppy12";
		objArr[0][1]="RJNR_HOME";
		objArr[0][2]="Created";
		objArr[0][3]=4;
		
		objArr[1][0]="harsha";
		objArr[1][1]="SDET_12ABN";
		objArr[1][2]="Created";
		objArr[1][3]=7;
		
		return objArr;
		
		
	}

}
