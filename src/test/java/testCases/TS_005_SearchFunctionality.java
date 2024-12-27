package testCases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectClasses.HomePagePOM;
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
		
		
		HomePagePOM hp = new HomePagePOM(driver);
		hp.enterProductName(prop.getProperty("productName1"));
		hp.clickSearchIcon();
		
		
	}
}
