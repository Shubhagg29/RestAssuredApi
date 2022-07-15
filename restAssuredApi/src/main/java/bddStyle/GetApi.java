package bddStyle;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class GetApi extends TestBase {
	
	String serviceUrl;
	String appUrl;
	String url;
	
	
	public GetApi() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {

		serviceUrl = prop.getProperty("URL");
		appUrl = prop.getProperty("serviceUrl");

		url = serviceUrl + appUrl;	

	}
	@Test
	public void getUsers() {
		
		
		given()
		.when()
		.get(url)
		.then().assertThat().statusCode(200).
		 and().
		body("data[1].first_name",equalTo("Lindsay"));
		
	
	}

}
