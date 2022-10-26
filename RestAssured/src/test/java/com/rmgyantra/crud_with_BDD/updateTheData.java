package com.rmgyantra.crud_with_BDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class updateTheData 
{
  @Test
  public void updateData()
  {
	JSONObject jobj = new JSONObject();
	jobj.put("createdBy", "Sai");
	jobj.put("projectName", "SDET_324076899");
	jobj.put("status", "Created");
	jobj.put("teamSize", "16");
	
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.put("http://localhost:8084/projects/TY_PROJ_807")
	.then()
	.assertThat().statusCode(200)
	.log().all();

}
}