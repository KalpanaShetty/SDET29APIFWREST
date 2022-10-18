package com.rmgyantraCRUDoperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectTest {
@Test
public void create(){
	JSONObject obj = new JSONObject();
	obj.put("createdBy", "Nayana_Shettyk");
	obj.put("projectName", "desmo9d8ad7");
	obj.put("status", "created");
	obj.put("teamSize", 5);
	given()
	       .contentType(ContentType.JSON)
	       .body(obj)
	       					
	.when()  
           .post("http://localhost:8084/addProject") 
    .then()
    		.assertThat().contentType(ContentType.JSON)
    		.and()
    		.assertThat().statusCode(201)
    		.log().all();
    		
	
}
}
