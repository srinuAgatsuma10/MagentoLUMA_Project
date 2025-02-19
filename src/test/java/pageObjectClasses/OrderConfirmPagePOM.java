package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmPagePOM extends BasePageObject {

	public OrderConfirmPagePOM(WebDriver driver) {
		super(driver);
	}
	
	// WebElements
	//Thank You Text
	@FindBy(xpath = "//span[@class='base']")
	WebElement thankuText;
	
	// Order Id
	@FindBy(xpath = "//a[@class='order-number']")
	WebElement orderID;
	
	// Continue Button
	@FindBy(xpath = "//a[@class='action primary continue']")
	WebElement continueBtn;
	
	
	//Action Methods
	public String getThankUText() {
		return(thankuText.getText());
	}
	
	public void clickContinue() {
		continueBtn.click();;
	}
	
	public String getOrderID() {
		return(orderID.getText());
	}
}
