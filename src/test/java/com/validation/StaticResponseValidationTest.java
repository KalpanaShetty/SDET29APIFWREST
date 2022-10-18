package com.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {
	@Test
	public void staticValidation(){
		String expecProjectName="rmgy1234567";
		Response response = when()
		   .get("http://localhost:8084/projects");
		
		String actProjectNAme = response.jsonPath().get("[0].projectName");
	System.out.println(actProjectNAme);
	/*response.then()
					.assertThat().statusCode(200)
					.assertThat().contentType(ContentType.JSON)
					.assertThat().log().all();*/
    Assert.assertEquals(expecProjectName, actProjectNAme)
    	
     ;
	}

}
