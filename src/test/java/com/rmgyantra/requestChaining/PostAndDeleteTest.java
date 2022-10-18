package com.rmgyantra.requestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.PojoClass.genericUtility.PostProjectPojoClassTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostAndDeleteTest {
@Test
public void postAndDelete(){
	Random random = new Random();
	int randomNum =  random.nextInt(1000);
	PostProjectPojoClassTest obj = new PostProjectPojoClassTest("ISRO", "ChandraYAna2"+randomNum, "created", 25);

	Response response =given().contentType(ContentType.JSON).body(obj)
    .when().post("http://localhost:8084/addProject");
	
	       String proID = response.jsonPath().get("projectId");
	       given()
	        .pathParam("ProjectID", proID)  
	      
     .when()
		    .delete("http://localhost:8084/projects/{ProjectID}")
     .then()
     .assertThat().statusCode(204).log().all();

}
}
