package com.rmgyantra.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameterTest 
{
	@Test
	public void parameter()
	{
		
		given()
				.queryParam("page", "3")
		.when()
		.get("https://reqres.in/api/users")  //query parameter we dont have to mention in the uri , it wil automatically take that
		.then().log().all();
	}

}
