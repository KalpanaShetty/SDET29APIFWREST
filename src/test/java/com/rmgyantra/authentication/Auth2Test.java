package com.rmgyantra.authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2Test {
	@Test
	public void authentication(){
		 Response response = given()
				.formParam("client_id", "chickenShop")
				.formParam("client_secret", "3f8de69e94cb3f5ea3a72eaf8489361d")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://example.com")
				.formParam("code", "2934")
		.when()
				.post("http://coop.apps.symfonycasts.com/token");
	     System.out.println(response);
		 String token = response.jsonPath().get("access_token");
		 
		 given()
		 		.auth().oauth2(token)
		 		.pathParam("USER_ID", 2934)
		 .when()
		 		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		 	.then().log().all();	
	
	

	}

}
