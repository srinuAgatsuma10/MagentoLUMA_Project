package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClasses.HomePagePOM;
import pageObjectClasses.SignInPOM;
import testBase.TestCaseBaseClass;

public class TS_002_SignInToTheApplication extends TestCaseBaseClass {
	
	
	@Test(groups = {"Sanity","Functional","Master"})
	public void signInApplication() {
		logger.info("****Starting TS_002_SignInToTheApplication ****");
		try
		{
			logger.info("Click on SignIn button");
		HomePagePOM hp = new HomePagePOM(driver);
		hp.clickSignIn();
		
		logger.info("Enter Valid credentials");
		SignInPOM sp = new SignInPOM(driver);;
		sp.emailInputBox(prop.getProperty("workingEmail1"));
		sp.passwordInputBox(prop.getProperty("we1Password"));
		
		logger.info("Click on SignButton");
		sp.signInbtn();
		
//		sp.forgotPasswordLink();
//		sp.btn_CreateNewAcc();
		
		logger.info("Validate Test Case");
		Boolean greetings = sp.getWlcomeMessage();		
		Assert.assertTrue(greetings);
		}
		catch(Exception e) {
			logger.error("Test Failed");
			logger.debug("Debug code");
			Assert.fail();
		}
		logger.info("****Finishing TS_002_SignInToTheApplication ****");
	}
	

}
