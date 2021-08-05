package pageObject;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	@FindBy(css = ".product_list.grid.row")
	private List<WebElement> productsList;

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public void productCount() {
		for (WebElement list : productsList) {
			Dimension size = list.getSize();
			System.out.println(size);
		}
		
	}

}
