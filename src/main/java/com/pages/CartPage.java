package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//div[contains(@class,'itemComponents-base-quantity')]")
    WebElement quantityDropdown;

    @FindBy(xpath="//div[@id='10']")
    WebElement quantity10;  
    
    @FindBy(xpath = "//div[normalize-space()='DONE']")
    WebElement clickDoneButton;

    @FindBy(xpath="//div[contains(@class, 'itemComponents-base-price itemComponents-base-bold')]")
    WebElement unitPrice;

    @FindBy(xpath="//div[@class='priceDetail-base-total ']//span[@class='priceDetail-base-value ']")
    WebElement totalPrice;
    
    
    @FindBy(xpath = "//span[contains(text(),'Platform Fee')]/following-sibling::span")
    WebElement platformfee;



    public void updateQuantity() {

        System.out.println("Updating quantity to 10");

        click(quantityDropdown);

        //click(quantity10);
        quantity10.click();
        click(clickDoneButton);
    }

    public int getUnitPrice() {

        String price = unitPrice.getText().replaceAll("[^0-9]", "");

        return Integer.parseInt(price);
    }

    public int getTotalPrice() {

        String total = totalPrice.getText().replaceAll("[^0-9]", "");

        return Integer.parseInt(total);
    }
    
    public int getPlatformfee() {

        String pf = platformfee.getText().replaceAll("[^0-9]", "");

        return Integer.parseInt(pf);
    }

}
