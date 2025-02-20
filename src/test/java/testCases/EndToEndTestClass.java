package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectClasses.CreateNewAccPOM;
import pageObjectClasses.HomePagePOM;
import pageObjectClasses.OrderConfirmPagePOM;
import pageObjectClasses.ProductDisplayPagePOM;
import pageObjectClasses.SearchResultsPagePOM;
import pageObjectClasses.ShoppingCartPagePOM;
import pageObjectClasses.SignInPOM;
import pageObjectClasses.SignOutPOM;
import testBase.TestCaseBaseClass;

/**
 * Test Case: End-to-End test
 * 
 * Steps:
 * 1) Perform Account Registration
 * 2) Logout after successful registration
 * 3) User Login with the registered email
 * 4) Search product and add to cart
 * 5) Perform Checkout process  
 */

public class EndToEndTestClass extends TestCaseBaseClass {

	@Test
	public void endToEndTest() throws Exception {
		SoftAssert sa = new SoftAssert();

		registerAccount(sa);
		signOutApplication(sa);
		signInApplication(sa);
		addToCartPlaceOrder(sa);

		sa.assertAll();
	}

	public void registerAccount(SoftAssert sa) throws Exception {

		HomePagePOM hp = new HomePagePOM(driver);
		hp.clickCreateAcc();

		String firstName = nameGenerate().toLowerCase();
		String lastName = nameGenerate().toLowerCase();
		String email = emailGenerator() + "@gmail.com";

		CreateNewAccPOM cnp = new CreateNewAccPOM(driver);
		cnp.enterFisrtName(firstName);
		cnp.enterLastName(lastName);
		cnp.enterEmailID(email);
		String confirmPass = passwordGenerator();
		cnp.enterPassword(confirmPass);
		cnp.enterConfirmPassword(confirmPass);
		cnp.clickCreateButton();
		String sucMessage = cnp.getSuccessMessage();

		sa.assertEquals(sucMessage, "Thank you for registering with Main Website Store.");
	}

	public void signOutApplication(SoftAssert sa) throws Exception {
		HomePagePOM hp = new HomePagePOM(driver);

		hp.clickDrpBtn();
		hp.clickSignOut();

		SignOutPOM sop = new SignOutPOM(driver);
		Boolean signOutMessage = sop.isMessageDisplayed();

		String url = driver.getCurrentUrl();
		if (signOutMessage == true) {
			Thread.sleep(5000);
			if (url == prop.getProperty(url)) {
				sa.assertTrue(true);
			}
		} else {
			sa.assertTrue(false);

		}
	}

	public void signInApplication(SoftAssert sa) {
		HomePagePOM hp = new HomePagePOM(driver);
		hp.clickSignIn();

		SignInPOM sp = new SignInPOM(driver);
		;
		sp.emailInputBox(prop.getProperty("workingEmail1"));
		sp.passwordInputBox(prop.getProperty("we1Password"));
		sp.signInbtn();

		Boolean greetings = sp.getWlcomeMessage();
		sa.assertTrue(greetings);
	}

	public void addToCartPlaceOrder(SoftAssert sa) {
		HomePagePOM hp = new HomePagePOM(driver);
		hp.enterProductName(prop.getProperty("productName1"));
		hp.clickSearchIcon(prop.getProperty("productName1"));

		SearchResultsPagePOM srp = new SearchResultsPagePOM(driver);
		// srp.clickOneProduct(); // Click Starting One product
		srp.clickRandomProduct(); // Click Random product

		ProductDisplayPagePOM pdp = new ProductDisplayPagePOM(driver);
		// pdp.selectSize();
		pdp.clickRandomSize();
		// pdp.selectColor();
		pdp.clickRandomColor();
		pdp.clickAddToCart();
		pdp.clickShoppingCartLink();

		ShoppingCartPagePOM scp = new ShoppingCartPagePOM(driver);
		scp.clickCheckOutBtn();
		scp.clickNextButton();
		scp.clickPlacingOrder();

		OrderConfirmPagePOM ocp = new OrderConfirmPagePOM(driver);
		String greetingText = ocp.getThankUText();
		ocp.clickContinue();

		String url = driver.getCurrentUrl();

		sa.assertEquals(greetingText.equals("Thank you for your purchase!") && url.equals(prop.getProperty(url)), true);

	}

}
