package pageObjectClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDisplayPagePOM extends BasePageObject{

	public ProductDisplayPagePOM(WebDriver driver) {
		super(driver);
	}

	//Explicit Wait
	WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//button[@id='product-addtocart-button']
	// Locators
	// Select size
	@FindBy(xpath = "//div[@id='option-label-size-143-item-167']")
	WebElement sizeBtn;
	
	// Select Color
	@FindBy(xpath = "//div[@id='option-label-color-93-item-56']")
	WebElement colorBtn;
	
	// Add to Cart
	@FindBy(xpath = "//button[@id='product-addtocart-button']")
	WebElement AddCartBtn;
	
	//Success Message
	@FindBy(xpath = "//div[@class='message-success success message']")
	WebElement successMsgPDP;
	
	// Wishlist button
	@FindBy(xpath = "//div[@class='product-addto-links']//a[@class='action towishlist']")
	WebElement wishList_Btn;

	//Add compare Button
	@FindBy(xpath = "//div[@class='product-addto-links']//a[@class='action tocompare']")
	WebElement addToCompare_Btn;

	// WishList Success Message
	@FindBy(xpath = "//div[@class='message-success success message']")
	WebElement wishListSuccess;

	// Product Compare Success Message
	@FindBy(xpath = "//div[@class='message-success success message']")
	WebElement productCompareSuccess;

	
	
	
	
	//Action Methods
	public void selectSize() {
		sizeBtn.click();
	}
	
	public void selectColor() {
//		WebElement colorSelection = myWait.until(ExpectedConditions.elementToBeClickable(colorBtn));
//		colorSelection.click();
		colorBtn.click();	
		}
	
	public void clickAddToCart() {
//		WebElement clickBtnADC = myWait.until(ExpectedConditions.elementToBeClickable(AddCartBtn));
//		clickBtnADC.click();
		AddCartBtn.click();
	}
	
	public Boolean isSuccessMessage() {
		try {
			return(successMsgPDP.isDisplayed());
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void clickWishListBtn(){
		wishList_Btn.click();
	}

	public Boolean isWishListSuccessMessage(){
		try {
		return(wishListSuccess.isDisplayed());
		}
		catch(Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	public void clickAddToCompareBtn(){
		addToCompare_Btn.click();
	}
	
	public Boolean isProCompSuccessMessage(){
		try {
		return(productCompareSuccess.isDisplayed());
	}
	catch(Exception e) {
		e.getMessage();
	}
	return null;
	}

}
