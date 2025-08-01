package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountsuccesspage {
	
	WebDriver driver;
   public Accountsuccesspage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
WebElement Succesmsg;





public Object getpageheading() {
	// TODO Auto-generated method stub
	return Succesmsg.getText();
}


}


