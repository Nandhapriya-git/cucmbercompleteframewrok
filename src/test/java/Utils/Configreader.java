package Utils;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Configreader {
	
	public Properties IntializeProperties() {

	Properties prop = new Properties();
	

	
	try {
		
		InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
		 if (input == null) {
             throw new RuntimeException("⚠️ config.properties file NOT found in classpath");
         }
		prop.load(input);
		
	}catch(Exception e) {
		
		e.printStackTrace();
	}
	
	return prop;
	
	}
	
	
}
