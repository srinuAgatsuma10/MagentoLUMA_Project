package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObject {

	public WebDriver driver;		//Initializing Driver
	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		//Using Page Factory Method
	}
}
