package com.rmgy.datadriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PojoClass.genericUtility.PostProjectPojoClassTest;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectUsingDataProviderTest {
@Test(dataProvider="bodyData")
public void addProject(String createdBy, String projectName, String status, int teamSize){
	PostProjectPojoClassTest obj = new PostProjectPojoClassTest(createdBy, projectName, status, teamSize);
     given()
           .body(obj).contentType(ContentType.JSON)
     .when()
     		.post("https://localhost:8084/addProject")
     .then()
     		.assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
}

@DataProvider
public Object[][] bodyData(){
	
	Object[][] objArray = new Object[4][4];
    
     objArray[0][0]="Berlin";
     objArray[0][1]="MoneyHeist1";
     objArray[0][2]="created";
     objArray[0][3]=5;
     
     objArray[1][0]="Tokyo";
     objArray[1][1]="MOneyHeist2";
     objArray[1][2]="created";
     objArray[1][3]=5;
     
     objArray[2][0]="Denver";
     objArray[2][1]="MOneyHesit3";
     objArray[2][2]="created";
     objArray[2][3]=5;
     
     objArray[3][0]="Ri0";
     objArray[3][1]="MoneyHeist4";
     objArray[3][2]="created";
     objArray[3][3]=5;
     
     return objArray;
}
}
