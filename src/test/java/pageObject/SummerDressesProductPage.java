package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummerDressesProductPage extends BasePage {
	@FindBy(css = ".cat-name")
	private WebElement title; // get title
	@FindBy(css = "#center_column > h1 > span.heading-counter")
	private WebElement thereAre;
	@FindBy(css = ".product-count")
	private WebElement showing;

	public SummerDressesProductPage(WebDriver driver) {
		super(driver);
	}

	public String getTitle() {
		return getText(title);
	}

	public String getThereAreProducts() {
		return getText(thereAre);
	}

	public String getShowingProduct() {
		return getText(showing);
	}

}
