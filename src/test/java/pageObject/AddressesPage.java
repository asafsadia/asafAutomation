package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends BasePage {
	@FindBy(css = "[name='message']")
	private WebElement commentField;
	@FindBy(css = "#center_column > form > p > button > span")
	private WebElement checkOutBtn;

	public AddressesPage(WebDriver driver) {
		super(driver);
	}

	public void sendText(String text) {
		js.executeScript("window.scrollBy(0,400)");
		fillText(commentField, text);
	}

	public void clickCkeckOut() {
		click(checkOutBtn);
	}

}
