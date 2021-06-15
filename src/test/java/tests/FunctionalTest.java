package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.qameta.allure.Story;
import pageObject.HomePage;
import pageObject.PrestaShopPage;
import utilities.AllureAttachment;

public class FunctionalTest extends BaseTest{
	
	String title = "Create and develop your business with PrestaShop";
	
	@Story("check links")
	@Test(priority = 1, description = "test functionality 1")
	public void clickOn1() {
		HomePage hp = new HomePage(driver);
		System.out.println(hp.getUrl());
		hp.clickShopNow();
		PrestaShopPage psp = new PrestaShopPage(driver);
		Assert.assertEquals(title, psp.getTitle());
		if (psp.getTitle().equalsIgnoreCase(title)) {
			System.out.println("Click on Passed test Successfully");
			System.out.println("Title: " + psp.getTitle());
		}
		AllureAttachment.attachText("functionality test -  Passed test Successfully");
		hp.back();
		
		hp = new HomePage(driver);
		hp.clickSale();
		psp = new PrestaShopPage(driver);
		Assert.assertEquals(title, psp.getTitle());
		System.out.println("Title: " + psp.getTitle());
		AllureAttachment.attachText("functionality test - Passed test Successfully");
		hp.back();
		
		hp = new HomePage(driver);
		hp.clickSummer();
		psp = new PrestaShopPage(driver);
		Assert.assertEquals(title, psp.getTitle());
		System.out.println("Title: " + psp.getTitle());
		AllureAttachment.attachText("functionality test - Passed test Successfully");
		hp.back();
	}
	
	@Story("check links")
	@Test(priority = 2, description = "test functionality 2")
	public void clickOn2() {
		HomePage hp = new HomePage(driver);
		hp.clickSearch();
		hp.sleep(1500);
		hp.clickCart();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
