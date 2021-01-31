package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class WomenPage extends BasePage {
	@FindBy(css = ".icon-th-list")
	private WebElement moveToList;
	@FindBy(css = ".icon-th-list")
	private WebElement mo;

	public WomenPage(WebDriver driver) {
		super(driver);
	}

	public void moveToList() {
		click(moveToList);
	}

	@Step("select item from the list {name}")
	public void chooseItem(String name) {
		List<WebElement> list = driver.findElements(By.cssSelector("[itemprop='name'] > a"));
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
				break;

			}

		}

	}

}
