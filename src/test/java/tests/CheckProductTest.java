package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObject.BlousesPage;
import pageObject.BlouseProductPage;
import pageObject.EveningDressesPage;
import pageObject.HomePage;
import pageObject.PrintedDressPage;
import pageObject.SummerDressesProductPage;
@Story("this test is testing the information of the product")
public class CheckProductTest extends BaseTest {
	// Validation Information //
	private final String title = "Printed Dress";
	private final String comment = "Your comment has been added and will be available once approved by a moderator";
	private final String description = "Printed evening dress with straight sleeves with black thin waist belt and ruffled linings.";
	private final String blousesTitle = "BLOUSES ";
	private final String bInfo = "Short sleeved blouse with feminine draped sleeve detail.";
	private final String SummerDressesT = "SUMMER DRESSES ";

	@Severity(SeverityLevel.NORMAL)
	@Story("choose product from the list")
	@Test(priority = 1, description = "check content form product")
	public void productTest() {
		HomePage hp = new HomePage(driver);
		hp.openWomenList("Evening Dresses");

		EveningDressesPage edp = new EveningDressesPage(driver);
		edp.goToMore();

		PrintedDressPage pdp = new PrintedDressPage(driver);
		Assert.assertEquals(pdp.getTitle(), title);
		pdp = new PrintedDressPage(driver);
		Assert.assertEquals(pdp.productDescription(), description);
		pdp.goToHome();
	}

	@Severity(SeverityLevel.NORMAL)
	@Story("choose product from the list")
	@Test(priority = 2, description = "check content form product")
	public void productTest2() {
		HomePage hp = new HomePage(driver);
		hp.openWomenList("Blouses");
		BlousesPage bp = new BlousesPage(driver);
		Assert.assertEquals(bp.getTitle(), blousesTitle);
		bp.goToMore();
		// Validation
		BlouseProductPage bpp = new BlouseProductPage(driver);
		bpp.getInfo();
		Assert.assertEquals(bpp.getInfo(), bInfo);
		bpp.goToHome();
	}

	@Severity(SeverityLevel.NORMAL)
	@Story("choose product from the list")
	@Test(priority = 3, description = "check content form product")
	public void productTest3() {
		HomePage hp = new HomePage(driver);
		hp.openDressesList("SUMMER DRESSES");
		// Validation
		SummerDressesProductPage sdpp = new SummerDressesProductPage(driver);
		Assert.assertEquals(sdpp.getTitle(), SummerDressesT);

		System.out.println("Actual: " + sdpp.getThereAreProducts());
		System.out.println("Showing: " + sdpp.getShowingProduct());
	}
}
