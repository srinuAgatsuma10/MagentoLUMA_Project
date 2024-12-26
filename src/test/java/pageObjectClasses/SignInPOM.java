package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPOM extends BasePageObject {

	public SignInPOM(WebDriver driver) {
		super(driver);
	}
	
	// Locators

	//input[@id='email']
	//fieldset[@class='fieldset login']//input[@id='pass']
	//fieldset[@class='fieldset login']//button[@id='send2']
	//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]
	//a[@class='action create primary']
	
	// Email Input
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailInput;
	
	// Password Input
	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement passInput;
	
	// SignIn button
	@FindBy(xpath = "//fieldset[@class='fieldset login']//button[@id='send2']")
	WebElement signIn_btn;
	
	// Forgot Password link
	@FindBy(xpath = "//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]")
	WebElement forgotPassword;
	
	// Create New account btn
	@FindBy(xpath = "//a[@class='action create primary']")
	WebElement createNewAcc;
	
	// Welcome Message
	@FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Alexander Holland!']")
	WebElement welcomeMessage;
	
	
	
	// Action Methods
	public void emailInputBox(String email) {
		emailInput.sendKeys(email);
	}
	
	public void passwordInputBox(String pass) {
		passInput.sendKeys(pass);
	}
	
	public void signInbtn() {
		signIn_btn.click();
	}

	public void forgotPasswordLink() {
		forgotPassword.click();
	}
	
	public void btn_CreateNewAcc() {
		createNewAcc.click();
	}
	
	public Boolean getWlcomeMessage() {
		try {
			//String welcome = welcomeMessage.getText().substring(0, 8);
			
			return(welcomeMessage.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
}
