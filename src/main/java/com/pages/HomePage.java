package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver); // To call parent class constructor.
		
	}
	
	// Locators
	@FindBy(xpath="//a[@class='myntraweb-sprite desktop-logo sprites-headerLogo ']")
	WebElement myntraLogo;
	

	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	WebElement searchField;
	
	@FindBy(xpath="//a[@class='desktop-submit']")
	WebElement submitButton;
	
	
	
	// Actions & Methods
	public boolean isLogoVisible() {
		return isVisible(myntraLogo);
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void searchProductOnSearchFiel(String productName) {
		
		System.out.println("Searching product: " + productName);
		isSendKeys(searchField, productName);
		
	}
	 // click the searchIcon Button...
    public void clickToSubmitButton() {
    	   click(submitButton);
    }

}
