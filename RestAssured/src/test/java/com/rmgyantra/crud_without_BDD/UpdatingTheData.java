package com.rmgyantra.crud_without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdatingTheData 
{
	//Here we are updating the whole data with the 
	@Test
	public void updateData()
	{
	JSONObject jobj = new JSONObject();
	
	jobj.put("createdBy", "Tharun");
	jobj.put("projectName", "SDET_0809");
	jobj.put("status", "On Gogin");
	jobj.put("teamSize", "16");
	
	RequestSpecification reqSpec = RestAssured.given();
	
	reqSpec.contentType(ContentType.JSON);
	reqSpec.body(jobj);
	
	Response rsps = reqSpec.put("http://localhost:8084/projects/TY_PROJ_804");
	
	ValidatableResponse vres = rsps.then();
	vres.assertThat().statusCode(200);
	vres.log().all();

}
}
