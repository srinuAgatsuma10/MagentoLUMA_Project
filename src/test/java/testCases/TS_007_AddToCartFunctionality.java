package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClasses.HomePagePOM;
import pageObjectClasses.ProductDisplayPagePOM;
import pageObjectClasses.SearchResultsPagePOM;
import testBase.TestCaseBaseClass;

public class TS_007_AddToCartFunctionality extends TestCaseBaseClass{
		
	// SignIn to the Application
//			@BeforeClass
//			public void signIN() {
//				HomePagePOM hp = new HomePagePOM(driver);
//				hp.clickSignIn();
//				SignInPOM sp = new SignInPOM(driver);;
//				sp.emailInputBox(prop.getProperty("workingEmail1"));
//				sp.passwordInputBox(prop.getProperty("we1Password"));
//				sp.signInbtn();
//			}
		@Test(groups = {"Sanity","Functional","Master"})
		public void addProductToCart() {
			
			HomePagePOM hp = new HomePagePOM(driver);
			hp.enterProductName(prop.getProperty("productName1"));
			hp.clickSearchIcon(prop.getProperty("productName1"));
			
			SearchResultsPagePOM srp = new SearchResultsPagePOM(driver);
		//	srp.clickOneProduct();   // Click Starting One product
			srp.clickRandomProduct();   // Click Random product
			
			ProductDisplayPagePOM pdp = new ProductDisplayPagePOM(driver);
			//pdp.selectSize();
			pdp.clickRandomSize();
			//pdp.selectColor();
			pdp.clickRandomColor();
			pdp.clickAddToCart();
			
			Boolean succMsg = pdp.isSuccessMessage();
			if(succMsg==true) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
}
