package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPage extends BasePage {
	@FindBy(css = ".page-subheading")
	private WebElement title;
	@FindBy(css = ".cheque-indent")
	private WebElement info;
	@FindBy(css = "#cart_navigation > button > span")
	private WebElement confirmBtn;

	public OrderSummaryPage(WebDriver driver) {
		super(driver);
	}

	public String getTitle() {
		return getText(title);
	}

	public String getInfo() {
		return getText(info);
	}

	public void confirm() {
		click(confirmBtn);
	}

}
