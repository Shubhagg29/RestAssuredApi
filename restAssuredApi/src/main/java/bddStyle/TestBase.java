package bddStyle;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;


public class TestBase {
	public Properties prop;
	
	//@BeforeSuite
	public TestBase() {
		try {
	
			String Path = System.getProperty("user.dir");		
			//To read Config property File 
			prop= new Properties();
			FileInputStream ip = new FileInputStream(Path + "/src/main/java/com/config/config.Properties");
			prop.load(ip);
			
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}
}
