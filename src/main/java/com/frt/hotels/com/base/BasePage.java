package com.frt.hotels.com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.frt.hotels.com.utils.ElementUtils;

public class BasePage {

	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	ElementUtils elementUtils;

	public WebDriver init_driver() {

		optionsManager = new OptionsManager(prop);
		elementUtils = new ElementUtils();
		driver = elementUtils.launchBrowser(optionsManager);
		
		elementUtils.deleteCookies(driver);
		elementUtils.maximize(driver);
		return driver;
	}

	public Properties init_properties() {
		prop = new Properties();
		String path = "./src/main/java/com/frt/hotels/com/config/config.properties";

		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("Some issue with config properties.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

}
