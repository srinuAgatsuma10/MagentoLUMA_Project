package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testBase.TestCaseBaseClass;


/**
 * Test Case: End-to-End test
 * 
 * Steps:
 * 1) Perform Account Registration
 * 2) Logout after successful registration
 * 3) User Login with the registered email
 * 4) Search product and add to cart
 * 5) Verify Shopping Cart contents
 * 6) Perform Checkout process
 */


public class EndToEndTestClass extends TestCaseBaseClass {

	@Test
	public void endToEndTest() {
		 SoftAssert sa = new SoftAssert();

		 
	}
	
}
