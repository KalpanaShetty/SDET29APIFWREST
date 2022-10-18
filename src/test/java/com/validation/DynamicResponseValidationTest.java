package com.validation;

import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest {
@Test
public void dynamicResponse(){
	String expecProjectId="TY_PROJ_1004";
	
	Response response = when().get("http://localhost:8084/projects");
	// List<String> pId = response.jsonPath().get("projectId");
	List<String> projectID = response.jsonPath().get("projectId");
	boolean flag=false;
	
	for (String actProjectID : projectID) {
		
		
		if(actProjectID.equals(expecProjectId)){
			System.out.println("Project name is matching");
			flag=true;
		}
		
	}
	Assert.assertTrue(flag);
	
}
}
