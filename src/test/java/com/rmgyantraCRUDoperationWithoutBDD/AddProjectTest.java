package com.rmgyantraCRUDoperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {
	@Test
	public void create(){
		//jason body
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Nayana_Shetty");
		obj.put("projectName", "FirmCA1");
		obj.put("status", "created");
		obj.put("teamSize", 5);
		
		//preconditions(body and content type)
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(obj);
		
		//action
		Response response = reqSpec.post("http://localhost:8084/addProject");
		ValidatableResponse validate = response.then();
	validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201); 
		validate.log().all();
		
		
	}
}
