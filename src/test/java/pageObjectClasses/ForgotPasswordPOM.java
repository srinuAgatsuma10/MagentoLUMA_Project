package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPOM extends BasePageObject {
	
	public ForgotPasswordPOM(WebDriver driver) {
		super(driver);
	}

	
	// Locators
	//Email Box
	@FindBy(xpath = "//input[@id='email_address']")
	WebElement emailTextBox;
	
	// Reset My Password Button
	@FindBy(xpath = "//button[@class='action submit primary']")
	WebElement resetPasswordBtn;
	
	// Success Message box
	@FindBy(xpath = "//div[@class='message-success success message']")
	WebElement seccessMeesage;
	
	
	// Action Methods
	public void enterEmailId(String email) {
		emailTextBox.sendKeys(email);
	}
	
	public void clickResetBtn() {
		resetPasswordBtn.click();
	}

	public Boolean isMeassageDisplayed() {
		return(seccessMeesage.isDisplayed());	}
}
