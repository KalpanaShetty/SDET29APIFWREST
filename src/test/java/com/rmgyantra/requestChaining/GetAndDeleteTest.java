package com.rmgyantra.requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAndDeleteTest {
@Test
public void getAndDelete(){
	Response response = when().get("http://localhost:8084/projects");
	String proID = response.jsonPath().get("[0].projectId");
	
	given()
 		.pathParam("projectID", proID)
 	.when()
 				.delete("http://localhost:8084/projects/{projectID}")
     .then()
     .assertThat().statusCode(204).log().all();


}
}
