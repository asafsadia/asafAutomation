package tests;

import org.testng.annotations.Test;

import pageObject.HomePage;

public class FunctionalTest extends BaseTest{
	
	@Test(priority = 1, description = "test functionality")
	public void test() {
		HomePage hp = new HomePage(driver);
		hp.clickOnExploratory();
		
	}

}
