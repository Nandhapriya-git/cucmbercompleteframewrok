package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driverfactory {
	
	static WebDriver driver=null;
	
	public static WebDriver Intializebrowser(String browsername) {
		
		if (browsername.equals("Chrome")) {
			
			driver=new ChromeDriver();
		}
		else if(browsername.equals("Firefox")) {
			
			driver=new FirefoxDriver();
		}	
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	
        return driver;
	
}



public static WebDriver getdriver() {
	

    return driver;
}

}