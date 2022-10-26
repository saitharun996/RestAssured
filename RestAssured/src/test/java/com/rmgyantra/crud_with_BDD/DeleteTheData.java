package com.rmgyantra.crud_with_BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteTheData 
{
	@Test
	public void deleteData()
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_807")
		.then()
		.assertThat().statusCode(204);
	}

}
