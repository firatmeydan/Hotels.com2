package com.frt.hotels.com.tests;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.frt.hotels.com.base.BasePage;
import com.frt.hotels.com.pages.HomePage;
import com.frt.hotels.com.pages.HotelsPage;
import com.frt.hotels.com.utils.ElementUtils;

public class TestCase1 {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ElementUtils elementsUtil;
	HomePage homepage;
	HotelsPage hotelsPage;

	@BeforeTest
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.init_properties();

		driver = basePage.init_driver();

		elementsUtil = new ElementUtils();
		elementsUtil.launchURL(driver, prop);
		homepage = new HomePage(driver);
		hotelsPage = new HotelsPage(driver);

	}

	@Test(description="\n*Enter Boston, Massachusetts, United States of America to search box and select it\n" + 
			"*Select check in and check out date\n" + 
			"*Select 1 room\n" + 
			"*Adults 2\n" + 
			"*Child 2\n" + 
			"*Child 1 == 4 years\n" + 
			"*Child 2 == 9 years\n" + 
			"*Select 3 stars and verify Hilton is in 3 stars’ hotels or not")

	public void testCase1() {
		hotelsPage.handleHomePage();
		hotelsPage.verifyHotelsPage();
		hotelsPage.distanceSelect();
		hotelsPage.starSelection();
		assertTrue(hotelsPage.verifyHilton());
	}

	@AfterTest
	public void quitBrowser() {
		elementsUtil.quitBrowser(driver);
	}

}
