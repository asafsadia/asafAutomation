package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummaryPage extends BasePage {
	@FindBy(css = "#summary_products_quantity") // product contains
	private WebElement cartContainsText;
	@FindBy(css = ".button.btn.btn-default.standard-checkout.button-medium > span")
	private WebElement checkOutBtn; // check out button

	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);
	}

	// return product contains
	public String getCartContains() {
		return getText(cartContainsText);
	}

	public void clickCheckOut() {
		click(checkOutBtn);
	}

}
