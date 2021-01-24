package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	@FindBy(css = "#center_column h1")
	private WebElement titlePage;
	@FindBy(css = ".logout")
	private WebElement logOutBtn;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public void signOut() {
		click(logOutBtn);
	}

	public String getTitle() {
		return getText(titlePage);
	}

}
