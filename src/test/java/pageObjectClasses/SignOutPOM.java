package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOutPOM extends BasePageObject{

	public SignOutPOM (WebDriver driver) {
		super(driver);
	}
	
	// Locators
	// You SignOut Message
	@FindBy(xpath = "//p[contains(text(),'You have signed out and will go to our homepage in')]")
	WebElement signOutMsg;
	
	//Action Methods
	public Boolean isMessageDisplayed () {
		try {
			return(signOutMsg.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
}
