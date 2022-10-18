package com.rmgyantra.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest {
@Test
public void pathParameter(){
	String proId="TY_PROJ_808";
	given().pathParam("projectID", proId)
	.when().delete("http://localhost:8084/projects/{projectID}")
	.then()
			.assertThat().statusCode(204).log().all();
}
}
