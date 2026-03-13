package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

	
	public SearchResultPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath = "//li[contains(@class,'product-base')][1]")
	WebElement firstProduct;
	
	public void selectFirstProduct() {

        System.out.println("Selecting first product");

        click(firstProduct);
    }

}
