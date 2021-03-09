package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObject.AddressesPage;
import pageObject.AuthenticationPage;
import pageObject.HomePage;
import pageObject.OrderConfirmationPage;
import pageObject.OrderSummaryPage;
import pageObject.PaymentPage;
import pageObject.ProductPage;
import pageObject.ShippingPage;
import pageObject.ShoppingCartSummaryPage;
import utilities.AllureAttachment;

@Story("this test add product to the cart and go to check out")
public class addToCartTest extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Story("select product \"Printed Dress\" from the list and add to cart")
	@Test(priority = 1, description = "add product to your list")
	public void addProduct1() {
		HomePage hp = new HomePage(driver);
		hp.chooseItem("Printed Dress");
		ProductPage pp = new ProductPage(driver);
		String actual = pp.getTitle();
		String expected = "Printed Dress";
		// Validation
		Assert.assertEquals(expected, actual);
		System.out.println("Product title: " + actual);
		pp.editProduct("3", "3");
		pp.homeBtn();
		AllureAttachment.attachText("add prodect 1 printed dress");
	}

	@Severity(SeverityLevel.NORMAL)
	@Story("select product \"Printed Summer Dress\" from the list and add to cart")
	@Test(priority = 2, description = "add product to your list")
	public void addproduct2() {
		HomePage hp = new HomePage(driver);
		hp.chooseItem("Printed Summer Dress");
		ProductPage pp = new ProductPage(driver);
		String actual = pp.getTitle();
		String expected = "Printed Summer Dress";
		// Validation
		Assert.assertEquals(expected, actual);
		System.out.println("Product title: " + actual);
		pp.editProduct("5", "2");
		pp.homeBtn();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Story("after selected product go to check out and check the total price")
	@Test(priority = 3, description = "go to check out")
	public void checkOut() {
		HomePage hp = new HomePage(driver);
		hp.cart();

		ShoppingCartSummaryPage scsp = new ShoppingCartSummaryPage(driver);
		String numOfProduct = scsp.getCartContains();
		System.out.println(numOfProduct);
		scsp.clickCheckOut();

		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.fillAlreadyRegistered("asafsadia400@gmail.com", "asaf9966");

		AddressesPage adp = new AddressesPage(driver);
		adp.sendText("This is my order");
		adp.clickCheckOut();

		ShippingPage sp = new ShippingPage(driver);
		sp.clickIAgree();
		sp.checkOut();

		PaymentPage pp = new PaymentPage(driver);
		pp.payBycheck();

		OrderSummaryPage osp = new OrderSummaryPage(driver);
		String expected1 = "CHECK PAYMENT";
		Assert.assertEquals(osp.getTitle(), expected1);
		String infoCheckPayment = osp.getInfo();
		System.out.println("Check info payment: " + infoCheckPayment);
		osp.confirm();

		OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
		String message = ocp.getMessage();
		System.out.println("End off order: " + message);
	}

}
