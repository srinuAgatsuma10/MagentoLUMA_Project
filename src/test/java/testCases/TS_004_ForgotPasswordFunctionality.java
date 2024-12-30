package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.ForgotPasswordPOM;
import pageObjectClasses.HomePagePOM;
import pageObjectClasses.SignInPOM;
import testBase.TestCaseBaseClass;

public class TS_004_ForgotPasswordFunctionality extends TestCaseBaseClass {
		
	
		@Test
		public void frogotPassword() {
			
			HomePagePOM hp = new HomePagePOM(driver);
			hp.clickSignIn();
			
			SignInPOM sip = new SignInPOM(driver);
			sip.forgotPasswordLink();
			
			ForgotPasswordPOM fpp = new ForgotPasswordPOM(driver);
			fpp.enterEmailId(prop.getProperty("workingEmail2"));
			fpp.clickResetBtn();
			Boolean succMsg = fpp.isMeassageDisplayed();
			
			if(succMsg ==  true) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
}