package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrestaShopPage extends BasePage{
	
	@FindBy(css = ".headings.h1.font-weight-semibold.header-title")
	private WebElement titleShop;

	public PrestaShopPage(WebDriver driver) {
		super(driver);
	}
	
	public String getTitle() {
		return getText(titleShop);
	}

}
