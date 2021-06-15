package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

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
	@FindBy(css = "#homeslider > li:nth-child(4) > div > p:nth-child(3) > button")
	private WebElement shopNow;
	@FindBy(css = "#htmlcontent_top > ul > li.htmlcontent-item-1.col-xs-4 > a > img")
	private WebElement cSale;
	@FindBy(css = "#htmlcontent_top > ul > li.htmlcontent-item-2.col-xs-4 > a > img")
	private WebElement cSummer;
	@FindBy(css = ".product_list.grid.row.homefeatured.tab-pane.active")
	private List<WebElement> listOfPopular;

	@FindBy(css = ".search_query.form-control.ac_input")
	private WebElement clickSearch;
	@FindBy(css = ".ajax_cart_no_product")
	private WebElement clickCart;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickCart() {
		click(clickCart);
		String url = getUrl();
		if (url.contains("order")) {
			back();
			System.out.println("The test passed");
		} else {
			System.out.println("The test false");
		}
	}

	public void clickSearch() {
		click(clickSearch);
		fillText(clickSearch, "Hi");
	}

	public void clickSummer() {
		click(cSummer);
	}

	public void clickSale() {
		click(cSale);
	}

	public void clickShopNow() {
		click(shopNow);
	}

	@Step("choose category from dresses list: {name}")
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

	@Step("choose category from women list: {name}")
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

	@Step("go to cart")
	public void cart() {
		click(cart);
	}

	@Step("click on women btn")
	public void clickOnWomenBtn() {
		click(womenBtn);
	}

	@Step("sign in button")
	public void clickOnSignin() {
		click(signinBtn);
	}

	@Step("women button")
	public void womenButton() {
		moveTo(dressesBtn);
	}

	@Step("selecting item {name}  from list on the home page")
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
