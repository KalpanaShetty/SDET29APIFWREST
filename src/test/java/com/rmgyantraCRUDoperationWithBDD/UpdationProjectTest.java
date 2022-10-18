package com.rmgyantraCRUDoperationWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class UpdationProjectTest {
@Test
public void patchproject(){
	JSONObject obj =new JSONObject();
	obj.put("createdBy", "Nayana_Shettyk");
	obj.put("projectName", "FirmCA19s51");
	obj.put("status", "on going");
	obj.put("teamSize",7);
	given()
        .contentType(ContentType.JSON)
        .body(obj)
        
    .when() 
          .put("http://localhost:8084/projects/TY_PROJ_2403")
     .then()
           .assertThat().contentType(ContentType.JSON)
           .assertThat().statusCode(200)
           .log().all();
	
}
}
