package com.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeaderValidationTest {
	@Test
	public void validation(){
		String expecContentType="application/json";
		String expectedVary="Access-Control-Request-Headers";
    Response response = when().get("http://localhost:8084/projects");
   String actaulContentType = response.getContentType();
   String actaulVary = response.getHeader("vary");
   response.then().log().all();
   Assert.assertEquals(expecContentType, actaulContentType);
   Assert.assertEquals(expectedVary, actaulVary);
	}

}
