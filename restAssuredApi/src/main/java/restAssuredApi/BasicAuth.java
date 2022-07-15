package restAssuredApi;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class BasicAuth extends Base {
	
	
	@Test
	public void loginBasicAuth() {
		Response res=	given().baseUri("https://fuscdrmsmc45-fa-ext.us.oracle.com/fscmRestApi/resources/11.13.18.05")
		            .auth().preemptive()
		            .basic("Federal","Welcome1")
		             .when()
		             .get("/fedGroups");
		            
	

//System.out.println(res.body().jsonPath().prettify());


JsonPath js= res.jsonPath();

List<Object> StrList=js.getList("items.LedgerGroupId");

System.out.println(StrList.get(0));

	}
	
	
	@Test
	public void loginWithBase() {
		
	int statusCode=	
		
			given().baseUri("https://fuscdrmsmc45-fa-ext.us.oracle.com/fscmRestApi/resources/11.13.18.05")
		    .get("/fedGroups").getStatusCode();
	         System.out.println(statusCode);
	
	}

}
