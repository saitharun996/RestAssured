package com.rmgyantra.crud_DIfferent_ways_to_post_request;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostingTheDataUsingHashMap 
{
   @Test
   public void PostData(){
	
	HashMap hp = new HashMap();
	hp.put("createdBy", "Tharun");
	hp.put("projectName", "SDET_01 248593");
	hp.put("status", "Created");
	hp.put("teamSize", "16");
	
	
	given()
	.contentType(ContentType.JSON)
	.body(hp)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.assertThat().statusCode(201)
	.log().all();

}
}
