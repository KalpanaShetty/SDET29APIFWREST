package com.rmgyantraCRUDoperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PartialUpdationTest {
@Test
public void patchproject(){
	JSONObject obj = new JSONObject();
	obj.put("name", "morpdheus");
	obj.put("job", "ziond resident");
	
	given()
	       .body(obj)
	       .contentType(ContentType.JSON)
	.when()
			.patch("https://reqres.in/api/users/2")
	.then()
	        .assertThat().contentType(ContentType.JSON)
	        .assertThat().statusCode(200)
			.log().all();
	       
	       
}
}
