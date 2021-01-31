package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class BlouseProductPage extends BasePage {
	@FindBy(css = "#short_description_content > p")
	private WebElement info;// get info
	@FindBy(css = ".icon-home")
	private WebElement home;
	@FindBy(css = "#wishlist_button")
	private WebElement addToWishList;
	@FindBy(css = ".fancybox-error")
	private WebElement getError;
	@FindBy(css = "[title='Close']")
	private WebElement closeError;
	@FindBy(css = ".login")
	private WebElement signinbtn;

	public BlouseProductPage(WebDriver driver) {
		super(driver);
	}

	public void signIn() {
		click(signinbtn);
	}

	public String getError() {
		return getText(getError);
	}

	public void closeError() {
		click(closeError);
	}

	@Step("click on add to wish list")
	public void clickOnAdd() {
		js.executeScript("window.scrollBy(0,400)");
		click(addToWishList);
	}

	@Step("get info from the product")
	public String getInfo() {
		return getText(info);
	}

	public void goToHome() {
		click(home);
	}

}
