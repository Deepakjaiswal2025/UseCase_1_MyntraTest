package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
		super(driver);
		
	}
 

    @FindBy(xpath="(//button[contains(@class,'size-buttons-size-button')])[1]")
    WebElement size;

    @FindBy(xpath="//div[text()='ADD TO BAG']")
    WebElement addToBag;

    @FindBy(xpath="//span[text()='GO TO BAG']")
    WebElement goToBag;

    @FindBy(xpath="//span[@class='pdp-price']")
    WebElement price;

  

    public int getPrice() {

        String priceText = price.getText();
        priceText = priceText.replaceAll("[^0-9]", "");

        System.out.println("Product price: " + priceText);

        return Integer.parseInt(priceText);
    }

    public void selectSize() {

        click(size);
    }

    public void addToBag() {

       click(addToBag);
    }

    public void goToBag() {

        click(goToBag);
    }

}