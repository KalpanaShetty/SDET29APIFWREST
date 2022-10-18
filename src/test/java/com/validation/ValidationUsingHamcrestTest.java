package com.validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class ValidationUsingHamcrestTest {
@Test
public void validation(){
	when().get("http://localhost:8084/projects")
	.then()
	
		//.assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS).log().all();
		.assertThat().body("[0].projectName", Matchers.equalTo("Rmgy483")).log().all();
		//.assertThat().contentType(Matchers.equalTo(ContentType.JSON));
	    
}
}
