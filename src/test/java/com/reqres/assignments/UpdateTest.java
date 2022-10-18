package com.reqres.assignments;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UpdateTest {
	@Test
	public void update(){
		JSONObject obj = new JSONObject();
		obj.put("name", "Kalpana Shetty");
		obj.put("job", "Software Engineer");
		
		given()
				
				.body(obj)
		.when()
		       .put("https://reqres.in/api/users/2")
		.then()
				
				.assertThat().statusCode(200)
				.log().all();
	}

}
