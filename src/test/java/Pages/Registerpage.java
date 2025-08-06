package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Elementutils;

public class Registerpage {
	
	WebDriver driver;
	
	public Registerpage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		}

	@FindBy (xpath="//input[@name='firstname']")
	WebElement Firstname;
			
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement YesNewsletterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWaring;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible' and contains(text(),'Warning: E-Mail Address is already registered!')]")
	private WebElement DuplicateEmailWarning;
	
	public void enterFirstName(String firstNameText) {
		
		Elementutils.typeText(driver, Firstname, 10, firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
		
	
		
	    Elementutils.typeText(driver, lastNameField, 10, lastNameText);
		
	}
	
	public void enterEmailAddress(String emailText) {
		
		Elementutils.typeText(driver, emailField, 10, emailText);
				
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		
	
		Elementutils.typeText(driver, telephoneField, 10, telephoneText);		
	}
	
	public void enterPassword(String passwordText) {
		
	
		Elementutils.typeText(driver, passwordField, 10, passwordText);
		
	}
	
	public void enterConfirmPassword(String passwordText) {
		
		Elementutils.typeText(driver, passwordConfirmField, 10, passwordText);
				
	}
	
	public void selectPrivacyPolicy() {
			
		Elementutils.clickElement(driver, privacyPolicyOption, 20);	
	}
	
	public Accountsuccesspage clickOnContinueButton() {
		
		Elementutils.clickElement(driver, continueButton, 20);

		return new Accountsuccesspage(driver) ;
		
	}
	
	public String getemailwarning() {
		
		String warningmessage=Elementutils.getTextFromElement(driver, DuplicateEmailWarning, 20);
		
		return warningmessage;
		
		
	}
	
	
}

