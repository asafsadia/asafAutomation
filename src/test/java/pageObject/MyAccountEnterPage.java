package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

import io.qameta.allure.Step;
import utils.Excel;

public class MyAccountEnterPage extends BasePage {
	@FindBy(css = "#email")
	private WebElement emailFild; // enter email
	@FindBy(css = "#passwd")
	private WebElement passwordFild; // enter password
	@FindBy(css = "#SubmitLogin")
	private WebElement signinBtn; // click on sign in button
	@FindBy(css = ".lost_password.form-group > a")
	private WebElement forgotYourPasswordBtn;
	@FindBy(css = ".page-heading")
	private WebElement getTitle; // check the title for this page
	@FindBy(css = ".alert.alert-danger")
	private WebElement geterrorMessage; // get error message after entering an incorrect email and password
	@FindBy(css = ".logout")
	private WebElement logOutBtn;

	public MyAccountEnterPage(WebDriver driver) {
		super(driver);
	}

	public void signOut() {
		click(logOutBtn);
	}

	@Step("get the error message")
	public String getErrorMessage() {
		return getText(geterrorMessage);
	}

	// get the title
	public String getTitle() {
		return getText(getTitle);
	}

	@Step("forgot your password button")
	public void forgotYourPasswordBtn() {
		click(forgotYourPasswordBtn);
	}

	@Step("send email from data/config.propertise {email}")
	public void sendEmail(String email) {
		fillText(emailFild, email);
	}

	@Step("send password from data/config.propertise {password}")
	public void sendPassword(String password) {
		fillText(passwordFild, password);
		click(signinBtn);
	}

	@Step("login whit valid {email} and {password}")
	public void login(String email, String password) {
		fillText(emailFild, email);
		fillText(passwordFild, password);
		click(signinBtn);
	}

	@DataProvider
	public Object[][] getDataFromExcel() { // src\test\resources\test\resources\data
		String excelPath = System.getProperty("user.dir") + "/src/test/resources/test/resources/data/input.xlsx";
		System.out.println(excelPath);
		Object[][] table = Excel.getTableArray(excelPath, "Login");
		return table;
	}

}
