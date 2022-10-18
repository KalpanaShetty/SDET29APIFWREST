package com.rmgyantraCRUDoperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@Test
public void updation(){
	JSONObject obj =new JSONObject();
	obj.put("createdBy", "kalpanaShetty");
	obj.put("projectName", "rmgy1234567");
	obj.put("status", "completed");
	obj.put("teamSize", 5);
	//preconditions(body and content type)
			RequestSpecification reqSpec = RestAssured.given();
			reqSpec.contentType(ContentType.JSON);
			reqSpec.body(obj);
			//action
			Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_1004");
         ValidatableResponse validate = response.then();

         validate.assertThat().contentType(ContentType.JSON);
 		validate.assertThat().statusCode(200); 
 		validate.log().all();
}
}
