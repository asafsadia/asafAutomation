package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EveningDressesPage extends BasePage{
	
	@FindBy(css = ".right-block")
	private WebElement overItem;
	@FindBy(css = ".button.lnk_view.btn.btn-default > span")
	private WebElement moreBtn;

	public EveningDressesPage(WebDriver driver) {
		super(driver);
	}
	
	public void goToMore() {
		js.executeScript("window.scrollBy(0,350)");
		moveTo(overItem);
		sleep(1000);
		click(moreBtn);
	}

}
