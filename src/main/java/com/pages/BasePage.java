package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	// driver & explicit wait
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// some reuseable method
	
	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		element.click();
	}
	
	public boolean isVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
		
	}
	
	public void isSendKeys(WebElement element, String text) {
		
		wait.until(ExpectedConditions.visibilityOf( element));
		element.clear();
		element.sendKeys(text);
	}

}
