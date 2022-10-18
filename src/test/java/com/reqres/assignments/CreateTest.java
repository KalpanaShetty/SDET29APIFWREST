package com.reqres.assignments;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateTest {
	@Test
	public void create(){
		JSONObject obj = new JSONObject();
		obj.put("name", "Kalpana Shetty");
		obj.put("job", "Software Engineer");
		
		given()
				.body(obj)
		.when()
		       .post("https://reqres.in/api/users")
		.then()	
				.assertThat().statusCode(201)
				.log().all();
	}

}
