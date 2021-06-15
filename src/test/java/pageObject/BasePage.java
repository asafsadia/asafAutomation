package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*Base class that wraps Selenium operations and will be inherited by all POMs*/
public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 15);
		Actions actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void scrollDown(WebElement el) {
	js.executeScript("arguments[0].scrollIntoView(true);", el);
}
	
//	public void scrollDown() {
//		js.executeScript("window.scrollBy(0,700)");
//	}
	
	public String getUrl() {
	String url = driver.getCurrentUrl();
	return url;
	}

	// send keys operation
	public void fillText(WebElement el, String text) {
		wait.until(ExpectedConditions.visibilityOf(el));
		highlightElement(el, "green");
		el.clear();
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
		highlightElement(el, "green");
		sleep(1000);
		el.click();
	}

	public String getText(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
		highlightElement(el, "yellow");
		sleep(1000);
		return el.getText();
	}

	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void alertOK(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	public void alertOK() {
		driver.switchTo().alert().accept();
	}

	public void selectByValue(WebElement el, String value) {
		Select s = new Select(el);
		s.selectByValue(value);
	}

	public void selectByIndex(WebElement el, int index) {
		wait.until(ExpectedConditions.visibilityOf(el));
		Select s = new Select(el);
		s.selectByIndex(index);
	}

	// move mouse to Element
	public void moveTo(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
		actions = new Actions(driver);
		actions.moveToElement(el).build().perform();
	}

	public void back() {
		driver.navigate().back();
	}

	/*
	 * Call this method with your element and a color like (red,green,orange etc...)
	 */
	private void highlightElement(WebElement element, String color) {
		// keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:yellow; border: 1px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		// Change the style back after few milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}

}
