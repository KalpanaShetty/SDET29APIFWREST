package com.rmgyantraCRUDoperationWithBDD;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class GetAllProjectsTest {
@Test
public void getallprojects(){
	when()
	      .get("http://localhost:8084/projects")
	.then()
	      .assertThat().statusCode(200)
	      .log().all();
	      
}
}
