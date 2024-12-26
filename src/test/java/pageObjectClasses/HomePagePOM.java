package pageObjectClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagePOM extends BasePageObject {

	public HomePagePOM(WebDriver driver) {
		super(driver);
	}
	
	//Explicit Wait
	WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	//Locators
	// Create New Account Link
	@FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
	WebElement CreateAccLink;
	
	// Sign-In Link
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement SignInLink;
	
	// Greetings DropDown Button
	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	WebElement drpDownBtn;
	
	// Sign Out Link
	@FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	WebElement SignOutLink;
	
	
	
	//Action Methods
	public void clickCreateAcc () {
		CreateAccLink.click();
	}
	
	public void clickSignIn() {
		WebElement signInClick = myWait.until(ExpectedConditions.elementToBeClickable(SignInLink));
		signInClick.click();
	}
	
	public void clickDrpBtn() {
		drpDownBtn.click();
	}
	
	public void clickSignOut() {
		SignOutLink.click();
	}
	
	

}
