package com.rmgyantraCRUDoperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {
@Test
public void delete(){
	when()
	      .delete("http://localhost:8084/projects/TY_PROJ_2406")
	.then()
	       .assertThat().statusCode(204)
	       .log().all();
	
	
}
}
