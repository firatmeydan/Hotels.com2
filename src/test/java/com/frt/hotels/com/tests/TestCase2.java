package com.frt.hotels.com.tests;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.frt.hotels.com.base.BasePage;
import com.frt.hotels.com.pages.HomePage;
import com.frt.hotels.com.pages.HotelsPage;
import com.frt.hotels.com.utils.ElementUtils;

public class TestCase2 {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ElementUtils elementsUtil;
	HomePage homepage;
	HotelsPage hotelsPage;

	@BeforeMethod
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.init_properties();

		driver = basePage.init_driver();

		elementsUtil = new ElementUtils();
		elementsUtil.launchURL(driver, prop);
		homepage = new HomePage(driver);
		hotelsPage = new HotelsPage(driver);

	}
	
	@Test(priority=2, description="4 Star Hotels", enabled=false)
	public void testCase2FourStar() {
		hotelsPage.handleHomePage();
		//hotelsPage.verifyHotelsPage();
		hotelsPage.distanceSelect();
		hotelsPage.fourStarSelection();
		hotelsPage.distanceVerification();
	}
	@Test(priority=3, description="5 Star Hotels", enabled=false)
	public void testCase2FiveStar() {
		hotelsPage.handleHomePage();
		//hotelsPage.verifyHotelsPage();
		hotelsPage.distanceSelect();
		hotelsPage.fiveStarSelection();
		hotelsPage.distanceVerification();
	}
	@Test(priority=1, description="3 Star Hotels")
	public void testCase2ThreeStar() {
		hotelsPage.handleHomePage();
		//hotelsPage.verifyHotelsPage();
		hotelsPage.distanceSelect();
		hotelsPage.starSelection();
		hotelsPage.distanceVerification();
	}
	@AfterMethod
	public void quitBrowser() {
		elementsUtil.quitBrowser(driver);
	}
}
