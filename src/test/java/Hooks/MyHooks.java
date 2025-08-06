package Hooks;

import java.util.Properties;

import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import DriverFactory.Driverfactory;
import Listeners.TestListener;
import Utils.Configreader;
import Utils.ExtentManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import Utils.Log;

public class MyHooks {
	
	WebDriver driver;
	
	@Before
        public void setup(Scenario scenario) {
            Properties prop = new Configreader().IntializeProperties();
            driver = Driverfactory.Intializebrowser(prop.getProperty("browser"));
            Log.info("Navigating to login page");
            driver.get(prop.getProperty("url"));

            
            ExtentTest test = ExtentManager.getInstance().createTest(scenario.getName());
          
        }

	

	
	@After
	public void Teardown(Scenario scenario) {
		
		String Scenarioname=scenario.getName().replaceAll(" ","_");
		
		if (scenario.isFailed()) {
			
		byte[] Screenshotsrc=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		scenario.attach(Screenshotsrc, "image/png", Scenarioname);
		}
		
		
	}
	
	@AfterAll
    public static void flushReport() {
        ExtentManager.getInstance().flush();
    }
	
}
