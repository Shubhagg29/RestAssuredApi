package restAssuredApi;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;

public class PostAPi {
	
	@Test
	public void createUser() {

        JSONObject json = new JSONObject();
      	json.put("name", "Jack");
         json.put("job", "AutomationEngineer");
		
	RequestSpecification request=given().baseUri("https://reqres.in/");
	
	    request.header("Content-Type", "application/json");

	    request.body(json.toJSONString());
	                    
     Response response =request.post("api/users");
	                    
	    System.out.println(response);
	
	
	}

}
