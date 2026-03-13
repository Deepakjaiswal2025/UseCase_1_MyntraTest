package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {

        try {

            FileInputStream fis = new FileInputStream("src/test/resources/Property/config.properties");

            prop = new Properties();

            prop.load(fis);

        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public String getUrl() {

        return prop.getProperty("url");
    }

    public String getProduct() {

        return prop.getProperty("product");
    }

    public String getQuantity() {

        return prop.getProperty("quantity");
    }
    public  String getProperty(String key) {
		return prop.getProperty(key);
	}

}