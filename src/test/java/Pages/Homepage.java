package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	WebElement Myacctountdropmenu;
	
	@FindBy (xpath="// a[contains(text(),'Login')]")
	WebElement Loginoption;
	
	@FindBy (xpath="// a[contains(text(),'Register')]")
	WebElement Registeroption;
	
	public void clickonMyaccount() {
		Myacctountdropmenu.click();
		
	}
	
	public void clickonLogin() {
		Loginoption.click();
		
	}
	
	public Registerpage clickonregister() {
		Registeroption.click();
		return new Registerpage (driver);
	}

}
