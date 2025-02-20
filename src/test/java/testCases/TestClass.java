package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pageObjectClasses.HomePagePOM;
import pageObjectClasses.OrderConfirmPagePOM;
import pageObjectClasses.ShoppingCartPagePOM;
import pageObjectClasses.SignInPOM;

public class TestClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		
		HomePagePOM hp = new HomePagePOM(driver);
//		hp.clickSignIn();
//		SignInPOM sp = new SignInPOM(driver);;
//		sp.emailInputBox("thundergod123@gmail.com");
//		sp.passwordInputBox("alex@nder1");
//		sp.signInbtn();
//		
		
		hp.clickLogo();
		hp.clickCartBox();
		hp.editCartBtn();
		
		ShoppingCartPagePOM scp = new ShoppingCartPagePOM(driver);
		scp.clickCheckOutBtn();
		scp.clickNextButton();		
		scp.clickPlacingOrder();
		
		
		OrderConfirmPagePOM ocp = new OrderConfirmPagePOM(driver);
		String greetingText = ocp.getThankUText();
		ocp.clickContinue();
		
		//String url = driver.getCurrentUrl();
				
		Assert.assertEquals(greetingText,"Thank you for your purchase!");
	}

}
