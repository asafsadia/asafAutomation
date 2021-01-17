package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlousesPage extends BasePage {
	@FindBy(css = ".cat-name")
	private WebElement title; // get the title
	@FindBy(css = "#center_column > ul > li > div > div.left-block")
	private WebElement goToMore;
	@FindBy(css = ".lnk_view.btn.btn-default > span")
	private WebElement moreBtn;

	public BlousesPage(WebDriver driver) {
		super(driver);
	}

	public String getTitle() {
		return getText(title);
	}

	public void goToMore() {
		js.executeScript("window.scrollBy(0,400)");
		moveTo(goToMore);
		sleep(1000);
		click(moreBtn);
	}

}
