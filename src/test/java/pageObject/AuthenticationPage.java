package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class AuthenticationPage extends BasePage {
	@FindBy(css = "#email")
	private WebElement emailField;
	@FindBy(css = "#passwd")
	private WebElement passwordField;
	@FindBy(css = ".icon-lock.left")
	private WebElement signInbtn;

	public AuthenticationPage(WebDriver driver) {
		super(driver);
	}

	@Step("fill Already Registered")
	public void fillAlreadyRegistered(String email, String password) {
		fillText(emailField, email);
		fillText(passwordField, password);
		click(signInbtn);
	}
}
