package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPagePOM extends BasePageObject{
	
	// Constructor
	public SearchResultsPagePOM(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	
	// Accessing Multiple Result Product names
	@FindBy(xpath = "//li//div//div//strong")
	List<WebElement> resultProductsName;
	
	// Select Single Product
	@FindBy(xpath = "//img[@alt='Selene Yoga Hoodie']")
	WebElement resultSingleProduct;
	
	
	// Action Methods
	public String resultProductNames() {
		for(WebElement rpn :resultProductsName ) {
			String rpName = rpn.getText();		
			return rpName;
		}
		return null;
	}
	
	public void clickOneProduct() {
		resultSingleProduct.click();
	}

}
