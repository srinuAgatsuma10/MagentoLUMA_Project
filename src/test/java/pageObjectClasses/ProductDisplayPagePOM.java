package pageObjectClasses;

import java.time.Duration;
import java.util.List;
import java.util.Random;

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
	// Select one size
	@FindBy(xpath = "//div[@id='option-label-size-143-item-167']")
	WebElement sizeBtn;	//div[@class="swatch-option text"]
	
	// Select Random Size
	@FindBy(xpath = "//div[@class='swatch-option text']")
	List<WebElement> selectRandomSize;
	
	// Select one Color
	@FindBy(xpath = "//div[@id='option-label-color-93-item-56']")
	WebElement colorBtn;	//div[@class="swatch-option color"]
	
	// Select Random Color
	@FindBy(xpath = "//div[@class='swatch-option color']")
	List<WebElement> selectRandomColor;
	
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
	
	// Big Thumbnail image	//div[@class='fotorama__stage__frame fotorama_vertical_ratio fotorama__loaded fotorama__loaded--img magnify-wheel-loaded fotorama__loaded--full fotorama__active']//img[2]
	// Left Arrow	//div[@aria-label='Previous']//div[@class='fotorama__arr__arr']
	// Right Arrow	//div[@aria-label='Next']//div[@class='fotorama__arr__arr']
	// Small Ligth Images
	
	
	
	
	//Action Methods
	public void selectSize() {
		sizeBtn.click();
	}
	
	public void clickRandomSize() {
		try {
			if(selectRandomSize.size()>0) {
				Random random = new Random();
				int randomIndex = random.nextInt(selectRandomSize.size()); 		
				// Select the product
				WebElement clickRandSize = selectRandomSize.get(randomIndex);
				clickRandSize.click();
			}
			}catch(Exception e) {
				e.getMessage();
			}
	}
	
	public void selectColor() {
//		WebElement colorSelection = myWait.until(ExpectedConditions.elementToBeClickable(colorBtn));
//		colorSelection.click();
		colorBtn.click();	
		}
	
	public void clickRandomColor() {
		try {
			if(selectRandomColor.size()>0) {
				Random random = new Random();
				int randomIndex = random.nextInt(selectRandomColor.size()); 		
				// Select the product
				WebElement clickRandColor = selectRandomColor.get(randomIndex);
				clickRandColor.click();
			}
			}catch(Exception e) {
				e.getMessage();
			}
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
