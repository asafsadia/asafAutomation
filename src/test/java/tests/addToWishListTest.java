package tests;

import org.testng.annotations.Test;

import pageObject.BlouseProductPage;
import pageObject.HomePage;
import pageObject.MyAccountEnterPage;
import utils.Configuration;

public class addToWishListTest extends BaseTest{
	
	@Test(priority = 1, description = "")
	public void addToWishList() {
		
		HomePage hp = new HomePage(driver);
		hp.chooseItem("Blouse");
		
		BlouseProductPage bpp = new BlouseProductPage(driver);
		bpp.clickOnAdd();
		String error = bpp.getError();
		System.out.println("Error: " + error);
		bpp.closeError();	
	}
	
	@Test(priority = 2, description = "")
	public void wishList() {
		BlouseProductPage bpp = new BlouseProductPage(driver);
		bpp.signIn();
		MyAccountEnterPage maep = new MyAccountEnterPage(driver);
		maep.sendEmail(Configuration.readProperty("email"));
		maep.sendPassword(Configuration.readProperty("password"));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
