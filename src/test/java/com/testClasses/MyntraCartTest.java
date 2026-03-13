package com.testClasses;

import com.base.BaseTest;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductPage;
import com.pages.SearchResultPage;

import org.testng.Assert;
import org.testng.annotations.Test;



public class MyntraCartTest extends BaseTest {

    @Test
    public void verifyCartPrice() throws InterruptedException {

        HomePage home = new HomePage(driver);

        home.searchProductOnSearchFiel(config.getProduct());
        home.clickToSubmitButton();
        Thread.sleep(2000);

        SearchResultPage search = new SearchResultPage(driver);
        
        String parentWindow = driver.getWindowHandle();
        
        search.selectFirstProduct();
         
        // handles window
        
        for(String window : driver.getWindowHandles())
        {
        	    if(!window.equals(parentWindow)) {
               driver.switchTo().window(window);
            }
        }

        ProductPage product = new ProductPage(driver);

        int productPrice = product.getPrice();

        product.selectSize();

        product.addToBag();

        product.goToBag();

        CartPage cart = new CartPage(driver);

        int unitPrice = cart.getUnitPrice();
        
        Thread.sleep(3000);

        cart.updateQuantity();

        Thread.sleep(3000);
        
        int plateformfee = cart.getPlatformfee();
        int totalPrice = cart.getTotalPrice() - plateformfee;

        int expectedPrice = unitPrice * Integer.parseInt(config.getQuantity());

        Assert.assertEquals(totalPrice, expectedPrice);
        log.info("... application vereified test succesfully...");
    }
}
