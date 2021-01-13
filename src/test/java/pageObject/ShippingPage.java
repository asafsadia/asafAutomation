package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends BasePage{
	
	@FindBy(css = "#form > div > p.checkbox > label")
	private WebElement iAgreeBtn;
	@FindBy(css = "#form > p > button > span")
	private WebElement checkOutBtn;

	public ShippingPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickIAgree() {
		click(iAgreeBtn);
	}
	
	public void checkOut() {
		click(checkOutBtn);
	}

}
