package pageObjectClasses;

import java.util.List;
import java.util.Random;

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
	
	// Accessing Multiple Result Product Images
		@FindBy(xpath = "//li[@class = \"item product product-item\"]//div//a[@class=\"product photo product-item-photo\"]")
		List<WebElement> resultProductsImg;
	
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
	
	/* if (products.size() > 0) {
                // Generate a random index
                Random random = new Random();
                int randomIndex = random.nextInt(products.size());

                // Select the random product
                WebElement selectedProduct = products.get(randomIndex);
                System.out.println("Selected Product: " + selectedProduct.getText());

                // Perform an action, e.g., click the product
                selectedProduct.click();
            } else {
                System.out.println("No products found on the page.");*/
	
	
	public void clickRandomProduct() {
		try {
		if(resultProductsImg.size()>0) {
			Random random = new Random();
			int randomIndex = random.nextInt(resultProductsImg.size()); 
			
			// Select the product
			WebElement clickProduct = resultProductsImg.get(randomIndex);
			clickProduct.click();
		}
		else {
			System.out.println("No products found on the page.");
		}
		}catch(Exception e) {
			e.getMessage();
		}
				
	}

}
