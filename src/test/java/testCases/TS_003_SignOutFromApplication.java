package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClasses.HomePagePOM;
import pageObjectClasses.SignInPOM;
import pageObjectClasses.SignOutPOM;
import testBase.TestCaseBaseClass;

public class TS_003_SignOutFromApplication extends TestCaseBaseClass {

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
	public void signOutFromApplication () throws Exception {

		try {

			HomePagePOM hp = new HomePagePOM(driver);
			/*---	// Sign IN to the Application
		HomePagePOM hp = new HomePagePOM(driver);
		hp.clickSignIn();
		SignInPOM sp = new SignInPOM(driver);;
		sp.emailInputBox(prop.getProperty("workingEmail1"));
		sp.passwordInputBox(prop.getProperty("we1Password"));
		sp.signInbtn(); ----*/

			// SignOut from the Application
			hp.clickDrpBtn();
			hp.clickSignOut();

			SignOutPOM sop = new SignOutPOM(driver);
			Boolean signOutMessage = sop.isMessageDisplayed();

			String url = driver.getCurrentUrl();

			if(signOutMessage==true) {
				Thread.sleep(5000);
				if(url == prop.getProperty(url)) {
					Assert.assertTrue(true);
				}
			}
			else {
				Assert.assertTrue(false);
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
}
