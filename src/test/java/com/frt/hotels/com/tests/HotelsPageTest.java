package com.frt.hotels.com.tests;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.frt.hotels.com.base.BasePage;
import com.frt.hotels.com.pages.HomePage;
import com.frt.hotels.com.pages.HotelsPage;
import com.frt.hotels.com.utils.ElementUtils;

public class HotelsPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ElementUtils elementsUtil;
	HomePage homepage;
	HotelsPage hotelsPage;

	@BeforeTest
	public void setUp() {

		basePage=new BasePage();
		prop=basePage.init_properties();
		
		driver=basePage.init_driver();

		elementsUtil=new ElementUtils();
		elementsUtil.launchURL(driver, prop);
		homepage=new HomePage(driver);
		hotelsPage=new HotelsPage(driver);
		
	}
	@Test(priority=1)
	
	public void verifyHotelsPage() {
		hotelsPage.handleHomePage();
		hotelsPage.verifyHotelsPage();
	}
	
	@Test(priority=2)
	public void distanceSelect() {
		elementsUtil.clearText(By.xpath(""));
		hotelsPage.distanceSelect();
	}
	@Test(priority=3)
	public void starSelect() {	
		hotelsPage.starSelection();
	}
	
	@Test(priority=4)
	public void verifyHilton() {
		assertTrue(hotelsPage.verifyHilton());		
	}
}
