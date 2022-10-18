package com.differentwaysToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectWithJsonObjectTest {
@Test
public void create(){
	JSONObject obj = new JSONObject();
	obj.put("createdBy", "Nayana_Shettyk");
	obj.put("projectName", "demo987");
	obj.put("status", "created");
	obj.put("teamSize", 5);
	
	given()
	       .contentType(ContentType.JSON)
	       .body(obj)          //preconditions
	       					
	.when()  
           .post("http://localhost:8084/addProject") //action
    .then()
    		.assertThat().contentType(ContentType.JSON)
    		.and()
    		.assertThat().statusCode(201)                  //validation
    		.log().all();
    		
	
}
}
