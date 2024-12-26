package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAccPOM extends BasePageObject {
	
	public CreateNewAccPOM(WebDriver driver) {
		super(driver);
	}

	//input[@id='firstname']
	//input[@id='lastname']
	//input[@id='email_address']
	//input[@id='password']
	//input[@id='password-confirmation']
	//button[@title='Create an Account']
	
	//Locators
	//First Name
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstName;
	
	//Last Name
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastName;
	
	// Email Id
	@FindBy(xpath = "//input[@id='email_address']")
	WebElement emailID;
	// Password
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	
	//Confirm Password
	@FindBy(xpath = "//input[@id='password-confirmation']")
	WebElement confirmPassword;
	
	//Create Acc Button
	@FindBy(xpath = "//button[@title='Create an Account']")
	WebElement createACC_btn;
	
	//Success Message
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement successMessage;
	
	
	//Action Methods
	public void enterFisrtName(String fname) {
		firstName.sendKeys(fname);
	}
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	public void enterEmailID(String emailid) {
		emailID.sendKeys(emailid);
	}
	public void enterPassword(String pass) {
		Password.sendKeys(pass);
	}
	public void enterConfirmPassword(String cpass) {
		confirmPassword.sendKeys(cpass);
	}
	public void clickCreateButton() {
		createACC_btn.click();
	}
	
	public String getSuccessMessage() {
		try {
			return(successMessage.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	
	
	
}
