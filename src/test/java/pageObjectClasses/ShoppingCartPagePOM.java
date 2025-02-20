package pageObjectClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPagePOM extends BasePageObject {

	public ShoppingCartPagePOM(WebDriver driver) {
		super(driver);
	}
	
	// Explicit Wait
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// WebElements
	// Proceed to checkout
	@FindBy(xpath = "//button[@data-role='proceed-to-checkout']")
	WebElement checkoutBtn;
	
	// Next button in Shipping Address page
	@FindBy(xpath = "//button[@class='button action continue primary']")
	WebElement nextBtn;
	
	// Place Order Button
	@FindBy(xpath = "//button[@title='Place Order']")
	WebElement placeOrderBtn;
	
	
	// Action Methods
	public void clickCheckOutBtn() {
		WebElement checkoutClick = myWait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
		checkoutClick.click();
		//checkoutBtn.click();
	}
	
	public void clickNextButton() {
		WebElement nextBtnClick = myWait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		nextBtnClick.click();
		//nextBtn.click();
	}

	public void clickPlacingOrder() {
		WebElement placeorderClick = myWait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
		placeorderClick.click();
		//placeOrderBtn.click();
	}
}
