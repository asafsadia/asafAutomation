package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{
	@FindBy(css = "#product_1_5_0_424111 > td.cart_quantity.text-center")
	private WebElement productQty1;
	@FindBy(css = "#product_5_25_0_424111 > td.cart_quantity.text-center > span")
	private WebElement productQty2;
	@FindBy(css = "#total_price")
	private WebElement totalPrice;
	@FindBy(css = "[title='Pay by check.']")
	private WebElement payCheckBtn;

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	// Check final product quantity 
	public String Qty() {
		String product1 = getText(productQty1);
		String product2 = getText(productQty2);
		return product1+product2;
	}
	
	// check total price
	public String total() {
		return getText(totalPrice);
	}
	
	public void payBycheck() {
		click(payCheckBtn);
	}

}
