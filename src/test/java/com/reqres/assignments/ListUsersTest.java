package com.reqres.assignments;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ListUsersTest {
	@Test
	public void listUsers(){
		
		given()
				.contentType(ContentType.JSON)
		.when()
		         .get("https://reqres.in/api/users?page=2")
		.then()
				.assertThat().contentType(ContentType.JSON)
				.assertThat().statusCode(200)
				.log().all();
	}

}
