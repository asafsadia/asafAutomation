package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
	
	@FindBy(css = "#quantity_wanted")
	private WebElement quantityFill;
	@FindBy(css = "#group_1")
	private WebElement selectSize;
	@FindBy(css = "#color_13")
	private WebElement selectColor;
	@FindBy(css = "#add_to_cart > button > span")
	private WebElement addToCartBtn;
	@FindBy(css = "#thumb_9")
	private WebElement ing1;
	@FindBy(css = "thumb_8")
	private WebElement img2;
	@FindBy(css = "[title='Continue shopping']")  
	private WebElement continueShoppingBtn; // continue Shopping Button
	@FindBy(css = ".icon-home")
	private WebElement home;
	@FindBy(css = "[itemprop='name']")
	private WebElement productTitl;
	

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public String getTitle() {
		return getText(productTitl);
	}
	
	public void homeBtn() {
		click(home);
	}
	
	public void editProduct(String quantity, String value) {
		js.executeScript("window.scrollBy(0,200)");
		sleep(500);
		fillText(quantityFill, quantity);
		sleep(500);
		selectByValue(selectSize, value);
		sleep(500);
		click(selectColor);
		sleep(500);
		click(addToCartBtn);
		click(continueShoppingBtn);
		sleep(500);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
