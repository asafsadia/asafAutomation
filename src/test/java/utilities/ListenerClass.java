package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import io.qameta.allure.Attachment;

public class ListenerClass extends TestListenerAdapter {
	// this class take a Screen shot after test is fails and work whit allure
	@Attachment(value = "Page Screenshot", type = "image/png", fileExtension = ".png")
	static byte[] attachScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object webDriverAttribute = result.getTestContext().getAttribute("WebDriver");
		if (webDriverAttribute instanceof WebDriver) {
			AllureAttachment.attachScreenshot((WebDriver) webDriverAttribute); // get screen shot to allure
			AllureAttachment.getPageSource((WebDriver) webDriverAttribute); // get page source to allure
		}
	}

}
