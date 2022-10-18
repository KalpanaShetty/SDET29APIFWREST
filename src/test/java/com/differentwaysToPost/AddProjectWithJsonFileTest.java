package com.differentwaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class AddProjectWithJsonFileTest {
@Test
public void addProject()
{
	File obj = new File("./src/test/resources/teamData.json");
	
	given()
			.body(obj).contentType(ContentType.JSON)
	.when()
			.post("http://localhost:8084/addProject")
	.then()
	       .assertThat().contentType(ContentType.JSON).statusCode(201).log().all();
	       
}
}
