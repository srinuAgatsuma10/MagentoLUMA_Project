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
	
	// Search Box Locator
	@FindBy(xpath = "//input[@id='search']")
	WebElement searchBox;

	// Search Icon locator
	@FindBy(xpath = "//button[@title='Search']")
	WebElement searchIcon;
	
	
	/*---- HomePagePOM Cart box functionality ----*/

	// Cart Box Locator
	@FindBy(xpath = "//a[@class='action showcart']")
	WebElement cartBox;

	//Cart Box action method
	public void clickCartBox(){
		cartBox.click();
	}


	/*---- HomePagePOM Cart box functionality ----*/
	
	
	
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
	
	// Search Box Action Method
	public void enterProductName(String proName){
		searchBox.clear();
		searchBox.sendKeys(proName);
	}

	// Search Icon Action Method
	public void clickSearchIcon(String proName){
		try {
			
		if(searchIcon.isEnabled()) {
		searchIcon.click();
		}
		else {
			enterProductName(proName);
			searchIcon.click();
		}
		}
		catch(Exception e) {
			e.getMessage();		}
	}
	
	

}
