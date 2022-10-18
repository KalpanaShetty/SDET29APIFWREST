package com.rmgyantra.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
@Test
public void authentication(){
	given()
	 		.auth().oauth2("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")
	.when()
			.get("https://api.github.com/user/repos")
	.then()
			.assertThat().statusCode(200).log().all();
}
}
	