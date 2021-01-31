package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class AddressesPage extends BasePage {
	@FindBy(css = "[name='message']")
	private WebElement commentField;
	@FindBy(css = "#center_column > form > p > button > span")
	private WebElement checkOutBtn;

	public AddressesPage(WebDriver driver) {
		super(driver);
	}

	@Step("send {text}")
	public void sendText(String text) {
		js.executeScript("window.scrollBy(0,400)");
		fillText(commentField, text);
	}

	@Step("click check out")
	public void clickCheckOut() {
		click(checkOutBtn);
	}

}
