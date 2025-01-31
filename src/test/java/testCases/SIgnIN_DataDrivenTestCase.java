package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClasses.HomePagePOM;
import pageObjectClasses.SignInPOM;
import testBase.TestCaseBaseClass;
import utilities.DataProviders;

public class SIgnIN_DataDrivenTestCase extends TestCaseBaseClass  {
		
	@Test(groups = {"Data Driven"},dataProvider="SignInData", dataProviderClass=DataProviders.class)
	public void signIn_DataDriven(String email, String pass, String res) throws Exception {
		
		
		try {
		HomePagePOM hp = new HomePagePOM(driver);
		hp.clickSignIn();
			
		SignInPOM sp = new SignInPOM(driver);;
		sp.emailInputBox(email);
		sp.passwordInputBox(pass);
		sp.signInbtn();
		
//		sp.forgotPasswordLink();
//		sp.btn_CreateNewAcc();
		
		Boolean greetings = sp.getWlcomeMessage();		
		//Assert.assertEquals(greetings, prop.getProperty("user1WelcomeMessage"));
		
		// Conditions
		if(res.equalsIgnoreCase("Valid")) {
			
			if(greetings == true) {
				hp.clickDrpBtn();
				hp.clickSignOut();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
			
		}
				
		if(res.equalsIgnoreCase("Invalid")) {
			
			if(greetings == true) {
				hp.clickDrpBtn();
				hp.clickSignOut();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
	}
		catch(Exception e) {
			Assert.fail();
		}
}
}