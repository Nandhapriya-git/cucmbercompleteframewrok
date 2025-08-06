package StepDefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import DriverFactory.Driverfactory;
import Pages.Accountsuccesspage;
import Pages.Homepage;
import Pages.Registerpage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utils.Log;

public class RegisterTest {

	WebDriver driver;
	private Registerpage registerPage;
	private Accountsuccesspage  accountsuccesspage;
	
	@Given("user navigates to Registration menu")
	public void user_navigates_to_registration_menu() {
		
		driver=Driverfactory.getdriver();
		Homepage hp =new Homepage(driver);
		hp.clickonMyaccount();
		registerPage = hp.clickonregister();
		
	}
		   
	

	@When("User enter the values into the below field")
	public void user_enter_the_values_into_the_below_field(DataTable dataTable) {
		
		//Registerpage Rp=new Registerpage(driver);
		
		Map <String,String> datamap=dataTable.asMap(String.class,String.class);
		
		Log.info("Enetering First name");
		registerPage.enterFirstName(datamap.get("firstname"));
		Log.info("Enetering last name");
		registerPage.enterLastName(datamap.get("lastname"));
		Log.info("Enetering email adress");
		registerPage.enterEmailAddress(datamap.get("email"));
		Log.info("Entering TelephoneNumber");
		registerPage.enterTelephoneNumber(datamap.get("telephone"));
		Log.info("Entering Password");
		registerPage.enterPassword(datamap.get("password"));
		Log.info("Entering confirm password");
		registerPage.enterConfirmPassword(datamap.get("confirmpassword"));
		
		
	}
	    
	@When("user click on privacy policy")
	public void user_click_on_privacy_policy() {
		
		Log.info("Click on Privacy policy");

		registerPage.selectPrivacyPolicy();
	  
	}

	@When("user clicks on continue")
	public void user_clicks_on_continue() {
		//Registerpage Rp=new Registerpage(driver);
		
		Log.info("Click on continue button");
		
		accountsuccesspage=registerPage.clickOnContinueButton();
	}
	 

	@Then("User registration should be complete")
	public void user_registration_should_be_complete() {
		
		Log.info("verifying Account created  message");
		Assert.assertEquals("Your Account Has Been Created!",accountsuccesspage.getpageheading());
	
	} 
	
	@Then("validate warning E-Mail Address is already registered!")
	public void validate_warning_e_mail_address_is_already_registered() {
		Log.info("verifying duplicate info  warning message");
		Assert.assertEquals("Warning: E-Mail Address is already registered!",registerPage.getemailwarning() );
	   
	}

}
