package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPagePOM extends BasePageObject {

	public ShoppingCartPagePOM(WebDriver driver) {
		super(driver);
	}

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
	
	
}
