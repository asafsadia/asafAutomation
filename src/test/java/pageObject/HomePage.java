package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	@FindBy(css = ".header_user_info > a")
	private WebElement signinBtn; // click on sign in button
	@FindBy(css = ".button.ajax_add_to_cart_button.btn.btn-default")
	private WebElement addToCart; // add to cart button
	@FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a") // women button
	private WebElement womenBtn; // Women Button
	@FindBy(css = "#quantity_wanted")
	private WebElement Quantity1; // select Quantity
	@FindBy(css = "#group_1")
	private WebElement selectSize; // select size//
	@FindBy(css = "#add_to_cart")
	private WebElement addToCartBtn;
	@FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
	private WebElement dressesBtn; // dresses button
	@FindBy(css = ".button.lnk_view.btn.btn-default")
	private WebElement moreBtn; //
	@FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
	private WebElement cart;
	@FindBy(css = "#button_order_cart")
	private WebElement checkOutbtn;
	@FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
	private WebElement womendropDoneBtn; // open women list
	@FindBy(css = "#block_top_menu > ul > li:nth-child(1) a")
	private List<WebElement> womenlist; // list in side women
	@FindBy(css = "#block_top_menu > ul > li:nth-child(2) a")
	private WebElement dressesdropDoneBtn; // open dresses list
	@FindBy(css = "#block_top_menu > ul > li:nth-child(2) a")
	private List<WebElement> dresseslist; // list in side dresses

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// choose category from dresses list
	public void openDressesList(String name) {
		moveTo(dressesdropDoneBtn);
		sleep(1000);
		for (WebElement el : dresseslist) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}

	// choose category from women list
	public void openWomenList(String name) {
		moveTo(womendropDoneBtn);
		sleep(1000);
		for (WebElement el : womenlist) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}

	public void cart() {
		click(cart);
	}

	public void clickOnWomenBtn() {
		click(womenBtn);
	}

	// sign in button
	public void clickOnSignin() {
		click(signinBtn);
	}

	// women button
	public void womenButton() {
		moveTo(dressesBtn);
	}

	// select item by name from list on the home page
	public void chooseItem(String name) {
		js.executeScript("window.scrollBy(0,700)");
		List<WebElement> list = driver.findElements(By.cssSelector("[itemprop='name'] > a"));
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);

				break;
			}
		}

	}
}
