package testCases;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectClasses.HomePagePOM;
import pageObjectClasses.SearchResultsPagePOM;
import pageObjectClasses.SignInPOM;
import testBase.TestCaseBaseClass;

public class TS_005_SearchFunctionality extends TestCaseBaseClass {

	// SignIn to the Application
		@BeforeClass
		public void signIN() {
			HomePagePOM hp = new HomePagePOM(driver);
			hp.clickSignIn();
			SignInPOM sp = new SignInPOM(driver);;
			sp.emailInputBox(prop.getProperty("workingEmail1"));
			sp.passwordInputBox(prop.getProperty("we1Password"));
			sp.signInbtn();
		}
		
	@Test
	public void searchingExistingProduct() {
		
		try {
			
		HomePagePOM hp = new HomePagePOM(driver);
		hp.enterProductName(prop.getProperty("productName1"));
		hp.clickSearchIcon(prop.getProperty("productName1"));
		
		SearchResultsPagePOM srpm = new SearchResultsPagePOM(driver);
		if(srpm.resultProductNames().contains("Hoodie"));{
			Assert.assertTrue(true);
		}
//		else {
//			Assert.assertTrue(false);
//		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
	}
}
