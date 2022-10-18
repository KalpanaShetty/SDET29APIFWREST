package com.rmgyantraCRUDoperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectsTest {
	@Test
	public void getallProject(){
	Response response = RestAssured.get("http://localhost:8084/projects");
	System.out.println(response.getContentType());
	System.out.println(response.getHeader("Vary"));
	System.out.println(response.getStatusCode());
	System.out.println(response.getBody());
	System.out.println(response.getTime());
	
	//System.out.println(response.prettyPrint());
	//print response including Header
	//System.out.println(response.prettyPeek());
	//print response in single line
	//System.out.println(response.asString());
	ValidatableResponse val = response.then();
	val.log().all();
}}
