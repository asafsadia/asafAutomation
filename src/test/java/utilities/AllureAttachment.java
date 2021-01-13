package utilities;

import java.nio.charset.StandardCharsets;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Attachment;

public class AllureAttachment {
	

	// this method send log to allure 
	@Attachment(value = "{0}", type = "text/plain", fileExtension = ".txt")
	public static String attachText(String message) {
		return message;
	}
	
	// this method get the page source to allure
	@Attachment(value = "Html source", type = "text/html", fileExtension = ".html")
	public static byte[] getPageSource(WebDriver driver) {
		return driver.getPageSource().getBytes(StandardCharsets.UTF_8);
	}
	
	// Screen shot element 
	@Attachment(value = "Element Screenshot", type = "image/png", fileExtension = ".png")
	public static byte[] attachElementScreenshot(WebElement element) {
		return element.getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "URL attachment", type = "text/uri-list", fileExtension = ".uri")
    public static String attachURL(String url) {
        return url;
    }

}
