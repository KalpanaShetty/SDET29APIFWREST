package com.validation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.List;

public class PostGetAndValidateTest {
	@Test
	public void addAndValidateProject(){
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "KNS");
		obj.put("projectName", "karnataka1");
		obj.put("status", "created");
		obj.put("teamSize", 9);
		       						
		String exceprojectName="karnataka1";
		given().contentType(ContentType.JSON).body(obj).when().post("http://localhost:8084/addProject");
		Response response = when()
			     .get("http://localhost:8084/projects");
		
		try{
			List<String> projectName = response.jsonPath().get("projectName");
		
		
		boolean flag=false;
		
		for (String actProjectName : projectName) {
			
			
			if(actProjectName.equals(exceprojectName)){
				System.out.println("Project name is matching");
				flag=true;
			}Assert.assertEquals(exceprojectName, actProjectName);
			Assert.assertTrue(flag);	
		}}catch(Exception e){
		}
		
	
	
	}}
