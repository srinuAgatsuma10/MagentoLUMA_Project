package testCases;

//import java.util.Random;
//import org.apache.commons.lang3.RandomStringUtils;
//import java.time.Duration;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClasses.CreateNewAccPOM;
import pageObjectClasses.HomePagePOM;
import testBase.TestCaseBaseClass;

public class TS_001_CreatingNewAccount extends TestCaseBaseClass {
	
	
	
//	public TS_001_CreatingNewAccount(WebDriver driver) {
//	super(driver);
//}	
	
	@Test(groups = {"Sanity","Functional","Master"})
	public void CreateNewAccount() {
		HomePagePOM hp = new HomePagePOM(driver);
		hp.clickCreateAcc();
		
		CreateNewAccPOM cnp = new CreateNewAccPOM(driver);
		cnp.enterFisrtName(nameGenerate().toLowerCase());
		cnp.enterLastName(nameGenerate().toLowerCase());
		cnp.enterEmailID(emailGenerator() + "@gmail.com");
		String confirmPass = passwordGenerator();
		cnp.enterPassword(confirmPass);
		cnp.enterConfirmPassword(confirmPass);
		cnp.clickCreateButton();
		String sucMessage = cnp.getSuccessMessage();
		
		Assert.assertEquals(sucMessage, "Thank you for registering with Main Website Store.");
	}
	
	
	
}
