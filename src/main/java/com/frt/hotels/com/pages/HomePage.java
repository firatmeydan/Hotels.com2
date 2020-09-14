package com.frt.hotels.com.pages;

import static org.testng.Assert.assertEquals;

import java.awt.RenderingHints.Key;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.frt.hotels.com.base.BasePage;
import com.frt.hotels.com.utils.AppConstants;
import com.frt.hotels.com.utils.ElementUtils;
import com.frt.hotels.com.utils.JavaScriptUtils;

public class HomePage {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	ElementUtils elementUtils;
	JavaScriptUtils javaScriptUtils;

	By destination = By.id("qf-0q-destination");
	By checkInDate = By.xpath("//*[contains(@class,'-check-in')]");
	By popUp = By.partialLinkText("Continue");
	By checkOutDate = By.xpath("//*[contains(@class,'-check-out')]");
	By roomNum=By.id("qf-0q-rooms");
	By adultNum=By.id("qf-0q-room-0-adults");
	By childrenNum=By.id("qf-0q-room-0-children");
	By firstChild=By.id("qf-0q-room-0-child-0-age");
	By secondChild=By.id("qf-0q-room-0-child-1-age");
	By search=By.xpath("//*[contains(@class,'cta cta-strong')]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage();
		prop = basePage.init_properties();
		elementUtils = new ElementUtils();
		javaScriptUtils = new JavaScriptUtils();
	}

	public void verifyPageTitle1() {
		assertEquals(elementUtils.getPageTitle(driver), AppConstants.HOMEPAGE_TITLE);
	}

	public void handlePopUp() {
		elementUtils.clickOn(driver, popUp);
	}

	public void sendDestination() {
		elementUtils.sendKeys(driver, destination, prop.getProperty("destination"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		elementUtils.clickOn(driver, By.xpath("//*[contains(@class, 'cont-hd-alt')]"));

	}

	public void selectDates() {
		elementUtils.clickOn(driver, checkInDate);
		// elementUtils.clearText(checkInDate);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		for (int i = 0; i < 8; i++)
			driver.findElement(checkInDate).sendKeys(Keys.SHIFT, Keys.LEFT);

		elementUtils.sendKeys(driver, checkInDate, prop.getProperty("startdate"));

		elementUtils.clickOn(driver, checkOutDate);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		for (int i = 0; i < 8; i++)
			driver.findElement(checkOutDate).sendKeys(Keys.SHIFT, Keys.LEFT);
		elementUtils.sendKeys(driver, checkOutDate, prop.getProperty("enddate"));
		elementUtils.clickOn(driver, By.xpath("//*[contains(@class, 'cont-hd-alt')]"));
	}
//	
//	public void roomSelect() {
//		elementUtils.selectByText(driver,roomNum, "1");
//	}
	
	public void adultSelect() {
		elementUtils.selectByText(driver,adultNum, "2");
	}
	
	public void childSelect() {
		elementUtils.selectByText(driver,childrenNum, "2");
		elementUtils.explicitWaitPresenceOfElement(driver, firstChild, 5);
		elementUtils.selectByText(driver,firstChild, "4");
		elementUtils.explicitWaitPresenceOfElement(driver, secondChild, 5);
		elementUtils.selectByText(driver,secondChild, "9");
		elementUtils.clickOn(driver, search);
	}

}
