package com.differentwaysToPost;

import org.testng.annotations.Test;

import com.PojoClass.genericUtility.PostProjectPojoClassTest;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectWithPojoClassTest {
@Test
public void addProject(){
	PostProjectPojoClassTest obj = new PostProjectPojoClassTest("samarth", "akash2", "created", 25);
 given()
 		.body(obj).contentType(ContentType.JSON)
 .when()
    	.post("http://localhost:8084/addProject")
  .then()
  		.assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
  		
    	
}
}
