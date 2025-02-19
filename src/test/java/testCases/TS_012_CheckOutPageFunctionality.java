package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.HomePagePOM;
import pageObjectClasses.OrderConfirmPagePOM;
import pageObjectClasses.ProductDisplayPagePOM;
import pageObjectClasses.SearchResultsPagePOM;
import pageObjectClasses.ShoppingCartPagePOM;
import testBase.TestCaseBaseClass;

public class TS_012_CheckOutPageFunctionality extends TestCaseBaseClass {

	@Test
	public void CheckOutPage() {
		
		logger.info("Searching A product");
		HomePagePOM hp = new HomePagePOM(driver);
		hp.enterProductName(prop.getProperty("productName1"));
		hp.clickSearchIcon(prop.getProperty("productName1"));
		
		logger.info("Adding Product to Cart");
		SearchResultsPagePOM srp = new SearchResultsPagePOM(driver);
		srp.clickRandomProduct(); 
		ProductDisplayPagePOM pdp = new ProductDisplayPagePOM(driver);
		//pdp.selectSize();
		pdp.clickRandomSize();
		//pdp.selectColor();
		pdp.clickRandomColor();
		pdp.clickAddToCart();
		
		hp.clickLogo();
		
		logger.info("Placing Order of that Product");
		hp.clickCartBox();
		hp.editCartBtn();
		ShoppingCartPagePOM scp = new ShoppingCartPagePOM(driver);
		scp.clickCheckOutBtn();
		scp.clickNextButton();
		scp.clickPlacingOrder();
		
		OrderConfirmPagePOM ocp = new OrderConfirmPagePOM(driver);
		String greetingText = ocp.getThankUText();
		ocp.clickContinue();
		
		String url = driver.getCurrentUrl();
				
		Assert.assertEquals(greetingText.equals("Thank you for your purchase!")  
				&& url.equals(prop.getProperty(url)),true);
		
		
	}
}
