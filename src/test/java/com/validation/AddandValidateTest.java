package com.validation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class AddandValidateTest {
	@Test
	public void addAndValidateProject(){
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "NayanaShettyKN");
		obj.put("projectName", "Ukranie1");
		obj.put("status", "created");
		obj.put("teamSize", 7);
		       						
		String exceprojectName="Ukranie";
		
		Response response =given().contentType(ContentType.JSON).body(obj).when().post("http://localhost:8084/addProject");
		
		String actuaprojectName = response.jsonPath().get("projectName");
		
		
		
		response.then().assertThat().contentType(ContentType.JSON).statusCode(201);
		Assert.assertEquals(exceprojectName, actuaprojectName);
		}}


