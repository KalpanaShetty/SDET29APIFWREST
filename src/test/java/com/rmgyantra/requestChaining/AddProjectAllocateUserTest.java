package com.rmgyantra.requestChaining;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.PojoClass.genericUtility.AllocateUserPojoClassTest;
import com.PojoClass.genericUtility.PostProjectPojoClassTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AddProjectAllocateUserTest {
@Test
public void addProjectAndAllocateUser(){
	Random random = new Random();
	int randomNum =  random.nextInt(1000);
	PostProjectPojoClassTest obj = new PostProjectPojoClassTest("ISRO", "ChandraYAna2"+randomNum, "created", 25);
	Response response =given().contentType(ContentType.JSON).body(obj)
    .when().post("http://localhost:8084/addProject");
   String projectNme  = response.jsonPath().get("projectName");
   
  // given().pathParam("projectName", pName);

  AllocateUserPojoClassTest obj2 =new AllocateUserPojoClassTest("sdet", "05/12/1996", "kns@gmail.com", "kxfgfdgfdns", 2, "9964677088", projectNme, "sefgdfs", "fgdrsh"+randomNum);
   
   given().contentType(ContentType.JSON).body(obj2)
	.when().post("http://localhost:8084/employees")
	.then().assertThat().contentType(ContentType.JSON).statusCode(201)
	.log().all();

}
}
