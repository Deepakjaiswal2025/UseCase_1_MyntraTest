package com.testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.utilities.ConfigReader;

public class HomePageTest extends BaseTest{
  
	HomePage homepage;
	
	
	
	
	@Test(priority = 1)
	public void verifyHomePageUrl() {
		homepage = new HomePage(driver);
		
		String expectedUrl = config.getUrl(); // form properties file, don't need to create object of configReader class because here inherit BaseTest class
		String actualUrl = homepage.getUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl);
		log.info("Home page verified with title successfully..");
		
	}
	
	
	@Test(priority = 2)
	public void verifyHomePageTitle() {
		homepage = new HomePage(driver);
		
		String expectedTitle = config.getProduct(); // form properties file, don't need to create object of configReader class because here inherit BaseTest class
		String actualTitle = homepage.getTitle();
		
		Assert.assertTrue(expectedTitle.contains(actualTitle));
		log.info("Home page verified with title successfully..");
	}
	
	@Test(priority = 3)
	public void verifyHomePageLogo() {
		homepage = new HomePage(driver);
		Assert.assertTrue(homepage.isLogoVisible());
		log.info("Home page verified with logo successfully..");
	}
	@Test(priority = 4)
	public void verifySearchBar() {
		homepage = new HomePage(driver);
		String productName = config.getProduct();
		
		homepage.searchProductOnSearchFiel(productName);
		log.info("search filed worked properly..");
		
		
	}
	
	
	
	
}
