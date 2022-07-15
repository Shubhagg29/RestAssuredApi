package restAssuredApi;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPI {

	// @Test
	public void getUsers() {

		given().baseUri("https://reqres.in/api")
		.get("users?page=2")
		.then().statusCode(200)
		.body("data[1].id",equalTo(8));

	}

	@Test
	public void getUsers2() {

		RequestSpecification request = given().baseUri("https://reqres.in/api");
		  Response response = request .get("users?page=2");

	int status=	response.getStatusCode();
		
		String body = response.asString();
		Assert.assertEquals(status, 200,"For Get request sttus should be 200");
		System.out.println(body);
	}

}
