package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage{
	
	@FindBy(css = ".alert.alert-success")
	private WebElement message;

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}
	
	public String getMessage() {
		return getText(message);
	}

}
