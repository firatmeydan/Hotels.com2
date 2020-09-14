package com.frt.hotels.com.tests;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.frt.hotels.com.base.BasePage;
import com.frt.hotels.com.pages.HomePage;
import com.frt.hotels.com.utils.ElementUtils;

public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ElementUtils elementsUtil;
	HomePage homepage;

	@BeforeTest
	public void setUp() {

		basePage=new BasePage();
		prop=basePage.init_properties();
		
		driver=basePage.init_driver();

		elementsUtil=new ElementUtils();
		elementsUtil.launchURL(driver, prop);
		homepage=new HomePage(driver);
	}

	@Test(priority=1)
	public void verifyPageTitle() {
		homepage.verifyPageTitle1();
	}
	
	@Test(priority=2)
	public void destinationSelect() {
		try {
			homepage.handlePopUp();
		} catch (Exception e) {
			
			System.out.println("No pop up or whatsoever!!!");
		}
		
		homepage.sendDestination();
	}
	
	@Test(priority=3)
	public void selectDates() {
		homepage.selectDates();
	}
	
	@Test(priority=4)
	public void adultSelect() {
		homepage.adultSelect();
	}
	@Test(priority=5)
	public void childrenSelect() {
		homepage.childSelect();
	}
}
