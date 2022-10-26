package com.rmgyantra_validation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class ValidationResponseTime 
{
	@Test
	public void  ValidationTime() {
		
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS)
        .assertThat().body("[0].projectName", Matchers.equalTo("deepak_pro-1"))
        .log().all();
	
	}

}
