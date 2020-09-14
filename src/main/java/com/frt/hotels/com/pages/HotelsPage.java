package com.frt.hotels.com.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.frt.hotels.com.base.BasePage;
import com.frt.hotels.com.utils.AppConstants;
import com.frt.hotels.com.utils.ElementUtils;
import com.frt.hotels.com.utils.JavaScriptUtils;

public class HotelsPage {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	ElementUtils elementUtils;
	JavaScriptUtils javaScriptUtils;
	HomePage homePage;
	

	By threeStar = By.id("f-star-rating-3");
	By fourStar = By.id("f-star-rating-4");
	By fiveStar = By.id("f-star-rating-5");

	By distance = By.xpath("//a[contains(text(),'Distance')]");
	By cityCenter = By.xpath("//a[contains(text(),'center')]");
	By scrolling=By.xpath("//*[contains(text(),'All prices are per room per night unless otherwise stated')]");
	WebElement element;
	public HotelsPage(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage();
		prop = basePage.init_properties();
		elementUtils = new ElementUtils();
		javaScriptUtils = new JavaScriptUtils();
		homePage = new HomePage(driver);
		javaScriptUtils=new JavaScriptUtils();
		//element=driver.findElement(scrolling);
	}

	public void handleHomePage() {
		homePage.handlePopUp();
		homePage.sendDestination();
		homePage.selectDates();
		homePage.adultSelect();
		homePage.childSelect();
	}

	public void verifyHotelsPage() {
		assertEquals(elementUtils.getPageTitle(driver), AppConstants.HOTELSPAGE_TITLE);
	}

	public void starSelection() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		elementUtils.clickOn(driver, threeStar);
	}

	public void fiveStarSelection() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		elementUtils.clickOn(driver, fiveStar);
	}

	public void fourStarSelection() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		elementUtils.clickOn(driver, fourStar);
	}

	public void distanceVerification() {
//		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL, Keys.END);
//		//javaScriptUtils.scrollPageDown(driver);
//		//javaScriptUtils.scrollIntoView(driver.findElement(scrolling), driver);
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
//		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL, Keys.END);
//		//javaScriptUtils.scrollIntoView(driver.findElement(scrolling), driver);
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
//		//elementUtils.clickOn(driver, By.id("scroll-to-top"));
//
//		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL, Keys.END);
//		//javaScriptUtils.scrollIntoView(driver.findElement(scrolling), driver);
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
//		elementUtils.clickOn(driver, By.id("scroll-to-top"));
//
//		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL, Keys.END);
//		//javaScriptUtils.scrollIntoView(driver.findElement(scrolling), driver);
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
//		//elementUtils.clickOn(driver, By.id("scroll-to-top"));
//		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL, Keys.END);
//		//javaScriptUtils.scrollIntoView(driver.findElement(scrolling), driver);
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
//		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL, Keys.END);
//		//javaScriptUtils.scrollIntoView(driver.findElement(scrolling), driver);
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,1500)");
		
		for(int i=0; i<20;i++) {
			
			js.executeScript("window.scrollBy(0,1000)");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
		List<WebElement> listHotels2 = driver.findElements(By.xpath("//li[contains(text(),'City center')]"));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		List<WebElement> hotelsNames = new ArrayList<WebElement>();

		for (int i = 0; i < listHotels2.size(); i++) {

			String text = listHotels2.get(i).getText();

			String[] textArray = text.split(" ");

			double mile = Double.parseDouble(textArray[0]);

			if (mile <= 10.0) {
				hotelsNames.add((driver.findElements(By.className("property-name-link"))).get(i));

			}
		}
		System.out.println("\nThere are "+hotelsNames.size()+" hotels. For the names of hotels, check down below:\n");

		int i=1;
		for (WebElement webElement : hotelsNames) {
			System.out.println(i+"- "+webElement.getText());
			i++;
		}
		System.out.println();
		
	}

	public void distanceSelect() {
		elementUtils.implicitWait(driver, 10);

		elementUtils.clickOn(driver, distance);

		elementUtils.clickOn(driver, cityCenter);
	}

	public boolean verifyHilton() {

		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL, Keys.END);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		List<WebElement> listHotels2 = (driver.findElements(By.className("property-name-link")));

		boolean isHiltonhere = false;

		for (WebElement webElement : listHotels2) {
			if (webElement.getText().contains("Hilton")) {
				System.out.println("\n         The Closest Hilton is this:\n" + webElement.getText() + "\n");
				isHiltonhere = true;
				break;
			}
		}
		return isHiltonhere;
	}

}

