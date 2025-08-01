package Hooks;

import java.util.Properties;

import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverFactory.Driverfactory;
import Utils.Configreader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import Utils.Log;

public class MyHooks {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		
		Properties prop= new Configreader().IntializeProperties();
		driver=Driverfactory.Intializebrowser(prop.getProperty("browser"));
		Log.info("Navigating to login page");
		driver.get(prop.getProperty("url"));
	}

	
	@After
	public void Teardown(Scenario scenario) {
		
		String Scenarioname=scenario.getName().replaceAll(" ","_");
		
		if (scenario.isFailed()) {
			
		byte[] Screenshotsrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		scenario.attach(Screenshotsrc, "image/png", Scenarioname);
		}
		
		
	}
	
}
