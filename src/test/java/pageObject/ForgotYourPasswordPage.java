package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotYourPasswordPage extends BasePage{
	
	@FindBy(css = "#email")  // enter your email address
	private WebElement emailAddress;
	@FindBy(css = ".submit > .btn.btn-default.button.button-medium") // click on retrieve password Button
	private WebElement retrievepasswordBtn;
	@FindBy(css = ".alert.alert-danger") // get the message 
	private WebElement errorMessageForGotPassword;

	public ForgotYourPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	public void forgotYourPassword(String email) {
		fillText(emailAddress, email);
		click(retrievepasswordBtn);
		
	}
	
	public String geterrorMessageForGotPassword() {
		return getText(errorMessageForGotPassword);
	}
	
	

}
