package com.rmgyantra.requestChaining;

import org.testng.annotations.Test;

import com.PojoClass.genericUtility.PostProjectPojoClassTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostAndGetProjectTest {
@Test
public void postAndGet(){
	Random random = new Random();
	int randomNum =  random.nextInt(1000);
	
	PostProjectPojoClassTest obj = new PostProjectPojoClassTest("London", "moov"+randomNum, "created", 25);
	Response response = given().contentType(ContentType.JSON).body(obj).when().post("http://localhost:8084/addProject");
    	String projId = response.jsonPath().get("projectId");
      
    given()
	        .pathParam("ProjectID", projId)
    .when()
        	.get("http://localhost:8084/projects/{ProjectID}")
    .then()
	.assertThat().statusCode(200).log().all();

}
}
