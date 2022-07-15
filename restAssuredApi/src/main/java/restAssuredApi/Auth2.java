package restAssuredApi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Auth2 {
	
	
	String token="";
	@Test(priority=0)
	public void generateToken() {
	Response resp=	given()
		.formParam("client_id", "EggsCheck")
		.formParam("client_secret", "01ab91ce389ff5ab76102eaf72d7a3b9")
		.formParam("grant_type", "client_credentials")
		.post("http://coop.apps.symfonycasts.com/token");
		
		token= resp.jsonPath().getString("access_token");
	
	
	}
	
	
	@Test(priority=1)
	public void authorizationToken() {	
		
	Response response=	RestAssured.given()
		.auth()
		.oauth2(token)
		.post("http://coop.apps.symfonycasts.com/api/2651/eggs-collect");
	
	System.out.println(response.getStatusCode());
	
	System.out.println(response.getBody().asString());
		
	}

}
