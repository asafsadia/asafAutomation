package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObject.ForgotYourPasswordPage;
import pageObject.HomePage;
import pageObject.MyAccountEnterPage;
import pageObject.MyAccountPage;
import utils.Configuration;

@Story("this test check the login process and forgot your password process")
public class LoginTest extends BaseTest {
	private String Title = "AUTHENTICATION"; // log out get title 
	@Severity(SeverityLevel.CRITICAL)
	@Story(" log in to your account")
	@Test(priority = 1, description = "log in whit valid email and password")
	public void Login() {
		HomePage hp = new HomePage(driver); // enter to the site and click login
		hp.clickOnSignin();
		
		MyAccountEnterPage maep = new MyAccountEnterPage(driver); // login page
		maep.sendEmail(Configuration.readProperty("email"));
		maep.sendPassword(Configuration.readProperty("password"));

		MyAccountPage map = new MyAccountPage(driver); // Validation
		String actual = map.getTitle();
		String expected = "AUTHENTICATION";
		// Validation
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
	}

	@Severity(SeverityLevel.NORMAL)
	@Story("log out from your account")
	@Test(priority = 2, description = "log out from your account")
	public void logOut() {
		MyAccountEnterPage maep = new MyAccountEnterPage(driver);
		maep.signOut();
		Assert.assertEquals(maep.getTitle(), Title);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Story("enter to your account whit not valid information")
	@Test(dataProvider = "getData", priority = 3, description = "log in whit not valid email and password")
	public void failsLogin(String email, String password) {
		HomePage hp = new HomePage(driver); // enter to the site and click login
		hp.clickOnSignin();

		MyAccountEnterPage map = new MyAccountEnterPage(driver); // Validation
		String actual = map.getTitle();
		String expected = "AUTHENTICATION";
		Assert.assertEquals(actual, expected);

		map = new MyAccountEnterPage(driver); // login whit email and password not valid (get data method)
		map.login(email, password);
		String actual1 = map.getErrorMessage(); // Validation
		String expected1 = "There is 1 error";
		// Validation
		Assert.assertEquals(actual, expected);
		System.out.println("error message: " + actual1);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Story(" check the forgot your password process")
	@Test(priority = 4, description = "forgot your password")
	public void forgotYourPassword() {
		MyAccountEnterPage maep = new MyAccountEnterPage(driver);
		maep.forgotYourPasswordBtn(); // click on forgot your password link

		ForgotYourPasswordPage fypp = new ForgotYourPasswordPage(driver); // enter email
		fypp.forgotYourPassword(" asafsadia400@gmail.com");

		String actual = fypp.geterrorMessageForGotPassword(); // Validation
		String expected = "A confirmation email has been sent to your address: asafsadia400@gmail.com";
		// Validation
		Assert.assertEquals(actual, expected);
		System.out.println("error message: " + actual);
	}

	// working whit fails login method
	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "asaf@gmail,com", "1234" }, { "hani@gmail,com", "2222" }, { "asi@gmail,com", "3333" },
				{ "lia@gmail,com", "9999" }, };
		return myData;
	}
}
