package com.reqres.assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PojoClass.genericUtility.PostProjectPojoClassTest;
import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class AddProjectVerifyDatabaseTest {
@Test
public void createAndVerify() throws Throwable {
	Random random = new Random();
	int randomNum =  random.nextInt(1000);
	PostProjectPojoClassTest obj = new PostProjectPojoClassTest("PrimeMinister", "operation ganga"+randomNum, "on going", 16);
	Response response = given()
	 		.body(obj).contentType(ContentType.JSON)
	 .when()
	    	.post("http://localhost:8084/addProject");
	System.out.println("project created ");
	
	 String projectID = response.jsonPath().get("projectId");
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	Statement stat = conn.createStatement();
	String query= "select * from project";
	ResultSet resultSet = stat.executeQuery(query);
	
	boolean flag=false;
	while(resultSet.next()){       
		if(projectID.equalsIgnoreCase(resultSet.getString(1))){
			System.out.println("Project id found in database");
			flag=true;
			
		}
	}conn.close();
	Assert.assertTrue(flag);
	
}
}
