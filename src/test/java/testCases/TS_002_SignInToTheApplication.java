package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClasses.HomePagePOM;
import pageObjectClasses.SignInPOM;
import testBase.TestCaseBaseClass;

public class TS_002_SignInToTheApplication extends TestCaseBaseClass {
	
	
	@Test
	public void signInApplication() {
		
		try
		{
		HomePagePOM hp = new HomePagePOM(driver);
		hp.clickSignIn();
		
		SignInPOM sp = new SignInPOM(driver);;
		sp.emailInputBox(prop.getProperty("workingEmail1"));
		sp.passwordInputBox(prop.getProperty("we1Password"));
		sp.signInbtn();
		
//		sp.forgotPasswordLink();
//		sp.btn_CreateNewAcc();
		
		Boolean greetings = sp.getWlcomeMessage();		
		Assert.assertTrue(greetings);
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
	

}
