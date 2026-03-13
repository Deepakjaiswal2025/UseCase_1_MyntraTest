package com.base;


import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utilities.ConfigReader;
import com.utilities.DriverFactory;

public class BaseTest {
	protected WebDriver driver;
	
	protected ConfigReader config = new ConfigReader();
	
	 protected Logger log = LogManager.getLogger(BaseTest.class);
			
			
    @BeforeMethod
    public void setup() {
     	
		log.info("Setting Brwoser setup...");

        driver = DriverFactory.initDriver(config.getProperty("browser"));
        log.info("chrome Broswer Launched...");
        
        driver.get(config.getUrl());
        log.info("Application oppend Successfully....");
        
        driver.manage().window().maximize();
		int wait = Integer.parseInt(config.getProperty("implicitlyWait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
    }

    @AfterMethod
    public void tearDown() {
      	log.info("Closing Browser");
        driver.quit();

    }

}
