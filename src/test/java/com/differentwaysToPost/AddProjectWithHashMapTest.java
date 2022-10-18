package com.differentwaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class AddProjectWithHashMapTest {
@Test
public void addProject(){
	HashMap obj = new HashMap();
	obj.put("createdBy", "Nayana_Shettyk");
	obj.put("projectName", "specimen12");
	obj.put("status", "created");
	obj.put("teamSize", 15);
	
	given()
			.body(obj).contentType(ContentType.JSON)
	.when()
	  		.post("http://localhost:8084/addProject")
	.then()
			.assertThat().contentType(ContentType.JSON).statusCode(201).log().all();
	  
}
}
