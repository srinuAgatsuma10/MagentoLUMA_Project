package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectClasses.HomePagePOM;
import pageObjectClasses.ProductDisplayPagePOM;
import pageObjectClasses.SearchResultsPagePOM;
import pageObjectClasses.SignInPOM;
import testBase.TestCaseBaseClass;

public class TS_011_ComapreProductFunctionality extends TestCaseBaseClass {

	// SignIn to the Application
//		@BeforeClass
//		public void signIN() {
//			HomePagePOM hp = new HomePagePOM(driver);
//			hp.clickSignIn();
//			SignInPOM sp = new SignInPOM(driver);;
//			sp.emailInputBox(prop.getProperty("workingEmail3"));
//			sp.passwordInputBox(prop.getProperty("we3Password"));
//			sp.signInbtn();
//		}
		
		@Test
		public void addProductToCompare(){ 
			// Search Product Functionality
			HomePagePOM hp = new HomePagePOM(driver);
			hp.enterProductName(prop.getProperty("productName1"));
			hp.clickSearchIcon(prop.getProperty("productName1"));
			
			SearchResultsPagePOM srp = new SearchResultsPagePOM(driver);
			//srp.clickOneProduct();
			srp.clickRandomProduct();
			
			ProductDisplayPagePOM pdp = new ProductDisplayPagePOM(driver);
//			//pdp.selectSize();
//			pdp.clickRandomSize();
//			//pdp.selectColor();
//			pdp.clickRandomColor();
			pdp.clickAddToCompareBtn();

			Boolean successMessage = pdp.isProCompSuccessMessage();
			//String currentURl = driver.getCurrentUrl();
			
			// Validation
			if(successMessage == true){
				Assert.assertTrue(true);
			}
			else{
				Assert.assertTrue(false);
			}
		}
}
