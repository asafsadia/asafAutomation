package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrintedDressPage extends BasePage {
	@FindBy(css = ".col-xs-12.col-sm-4 > h1")
	private WebElement PrintedDressTitle;
	@FindBy(css = "#product_comments_block_extra > ul > li > a")
	private WebElement writeReviewBtn;
	@FindBy(css = "#comment_title")
	private WebElement titleFiled;
	@FindBy(css = "#content")
	private WebElement commentFiled;
	@FindBy(css = "#submitNewMessage > span")
	private WebElement sendBtn;
	@FindBy(css = ".fancybox-inner > p")
	private WebElement comment; // get comment
	@FindBy(css = ".fancybox-opened > div > div > div > p.submit > button > span")
	private WebElement okBtn;
	@FindBy(css = "#short_description_content p")
	private WebElement printDescription;
	@FindBy(css = ".icon-home")
	private WebElement goToHomePage;

	public PrintedDressPage(WebDriver driver) {
		super(driver);
	}

	public void goToHome() {
		click(goToHomePage);
	}

	public String productDescription() {
		return getText(printDescription);
	}

	// print the comment after you wrote one
	public String getComment() {
		return getText(comment);
	}

	// return title from product page
	public String getTitle() {
		return getText(PrintedDressTitle);
	}

	// write a review
	public void writeReview(String title, String comment) {
		click(writeReviewBtn);
		fillText(titleFiled, title);
		fillText(commentFiled, comment);
		click(sendBtn);
	}

}
