package pojo;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Payload {

	public static void main(String args[]) {
		try {
			usingApacheJuneau();
		} catch (SerializeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void usingJackSon() throws JsonProcessingException {

		Company company = new Company("Apple", "US", "5Bilion$");

		String sellerNames[] = { "Stalin", "Random", "Versache" };

		Product product = new Product("EY", "White", 40000, sellerNames, company);

		// Using JackSon APi converting POJO to Json String
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);

		System.out.println(jsonString);

		String stringJson = "{\n" + "  \"name\" : \"EY\",\n" + "  \"color\" : \"White\",\n" + "  \"price\" : 40000,\n"
				+ "  \"sellerNames\" : [ \"Stalin\", \"Random\", \"Versache\" ],\n" + "  \"company\" : {\n"
				+ "    \"cname\" : \"Apple\",\n" + "    \"location\" : \"US\",\n" + "    \"worth\" : \"5Bilion$\"\n"
				+ "  }\n" + "}\n" + "";

		// Converting JSON String to POJO
		objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Product productobj = objMapper.readValue(stringJson, Product.class);

		System.out.println(productobj.getName());

	}

	public static void usingApacheJuneau() throws SerializeException, ParseException {
	
		Company company = new Company("Apple", "US", "5Bilion$");
		String sellerNames[] = { "Stalin", "Random", "Versache" };
		Product product = new Product("EY", "White", 50000, sellerNames, company);
		JsonSerializer jsonSerializer	=JsonSerializer.DEFAULT_READABLE;
	
	
		//Serializing (pojo to JsonString)
	String json	=jsonSerializer.serialize(product);
	System.out.println(json);
	
	//Serializing (pojo to xml)
	XmlSerializer xmlSerializer=XmlSerializer.DEFAULT_NS_SQ_READABLE;
	String xml =xmlSerializer.serialize(json);
	
	//Serializing (pojo to html)
	HtmlSerializer htmlSerializer	=HtmlSerializer.DEFAULT_SQ_READABLE;
	String html =xmlSerializer.serialize(json);
	
	
	String resultJson = "{\n" + "  \"name\" : \"EY\",\n" + "  \"color\" : \"White\",\n" + "  \"price\" : 40000,\n"
			+ "  \"sellerNames\" : [ \"Stalin\", \"Random\", \"Versache\" ],\n" + "  \"company\" : {\n"
			+ "    \"cname\" : \"Apple\",\n" + "    \"location\" : \"US\",\n" + "    \"worth\" : \"5Bilion$\"\n"
			+ "  }\n" + "}\n" + "";
	
	JsonParser jsonParser=	JsonParser.DEFAULT;
	
Product resProduct=	jsonParser.parse(json,Product.class);

System.out.println(resProduct.getCompany());
	
	}
}
