package restAssuredApi;



import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class Base {
	
	@BeforeClass
	public void setUp() {
		RestAssured.authentication= RestAssured.preemptive().basic("Federal", "Welcome1");
	}

}
