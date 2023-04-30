package com.testrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) { // constructor by passing webdriver

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='fromCity']")
	private WebElement fromcity;

	@FindBy(xpath = "//p[text()='Pune, India']")
	private WebElement selectcity;

	@FindBy(xpath = "//input[@id='toCity']")
	private WebElement tocity;

	@FindBy(xpath = "//p[text()='Bengaluru, India']")
	private WebElement toselect;

	@FindBy(xpath = "(//p[text()='12'])[2]")
	private WebElement departure;

	@FindBy(xpath = "//a[text()='Search']")
	private WebElement search;

	@FindBy(xpath = "//span[@class=\"bgProperties icon20 overlayCrossIcon\"]")
	private WebElement close;

	@FindBy(xpath = "(//span[text()='View Prices'])[1]")
	private WebElement view_price;

	@FindBy(xpath = "(//button[text()='Book Now'])[1]")
	private WebElement book_now;

	public WebElement getView_price() {
		return view_price;
	}

	public WebElement getClose() {
		return close;
	}

	public WebElement getBook_now() {
		return book_now;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getDeparture() {
		return departure;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFromcity() {
		return fromcity;
	}

	public WebElement getSelectcity() {
		return selectcity;
	}

	public WebElement getTocity() {
		return tocity;
	}

	public WebElement getToselect() {
		return toselect;
	}

}
