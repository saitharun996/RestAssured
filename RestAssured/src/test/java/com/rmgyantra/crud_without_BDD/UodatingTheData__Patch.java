package com.rmgyantra.crud_without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UodatingTheData__Patch {

	@Test
	public void updateData()
	{
	JSONObject jobj = new JSONObject();
	
	jobj.put("name", "morpheus");
	jobj.put("job", "SDET7_009");
	
	
	RequestSpecification reqSpec = RestAssured.given();
	
	reqSpec.contentType(ContentType.JSON);
	reqSpec.body(jobj);
	
	Response rsps = reqSpec.patch("https://reqres.in/api/users/2");
	
	ValidatableResponse vres = rsps.then();
	vres.assertThat().statusCode(200);
	vres.log().all();

}


}
