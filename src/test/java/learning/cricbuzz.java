package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class cricbuzz {

	public static void main(String[] args) {
		
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.cricbuzz.com/");
		driver.manage().window().maximize();
		
		Actions action= new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Teams']"))).build().perform();
		
		driver.findElement(By.xpath("//a[@title='India Cricket Team']")).click();
		driver.findElement(By.xpath("//a[@title='India Cricket Team Stats']")).click();
		
		List <WebElement> palyerelemnts=driver.findElements(By.xpath("//td[@class='cb-srs-stats-td text-left']"));
		
	
		List <WebElement> avgelemnt=driver.findElements(By.xpath("//td[@class='cb-srs-stats-td'][4]"));
		
		Map<String,Double> Playerandavg= new HashMap<String,Double>();
		
		for (int i=0;i<palyerelemnts.size();i++) {
			
			String playername=palyerelemnts.get(i).getText();
			String playeravg=avgelemnt.get(i).getText();
			 double avg = Double.parseDouble(playeravg);
			
			Playerandavg.put(playername, avg);
			
			
		}
		
		System.out.println(Playerandavg);
		
		
		
		
	}

}
