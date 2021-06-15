package tests;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.AllureAttachment;

public class BaseTest {

	WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass(description = "initializing driver and navigating to tested site url")
	public void setup(@Optional("Chrome") String browser, ITestContext testContext) {	
		switch (browser) {
		case "Chrome":
//			WebDriver driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "explorer":
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions capabilities = new InternetExplorerOptions();
			capabilities.ignoreZoomSettings();
			driver = new InternetExplorerDriver(capabilities);
			break;
		default:
			throw new IllegalArgumentException("no such browser " + browser);
		}
		driver.manage().window().maximize();
		testContext.setAttribute("WebDriver", this.driver); // take screen shot
		driver.get(utils.Configuration.readProperty("TestedSiteUrl"));
		AllureAttachment.attachURL("http://automationpractice.com/index.php");
	}

//	@AfterClass(description = "closing driver")
//	public void tearDone() {
//		driver.quit();
//	}

//	 This method will run after watch test, it will take screen shot only for
//	 tests that failed
	@AfterMethod
	public void failedTest(ITestResult result) {
		// check if the test failed
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// result.getname() method will give you current test case name.
			// ./ScreenShots/ tell you that, in your current directory, create folder
			// ScreenShots. dot represents current directory
		}
	}
}
