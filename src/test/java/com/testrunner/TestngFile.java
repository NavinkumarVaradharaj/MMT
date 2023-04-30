package com.testrunner;

import com.Project.BaseClass;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.Project.*;

public class TestngFile extends BaseClass {

	public static WebDriver driver;

	static PageObjectManager pom = new PageObjectManager(driver);

	@BeforeSuite
	public static void browserLaunch() {
		browserLaunch("chrome");
		launchUrl("https://www.makemytrip.com/");
	}

	

	@Test()
	public static void select() {
		clickWebelement(pom.getHome().getFromcity());
		clickWebelement(pom.getHome().getSelectcity());
		clickWebelement(pom.getHome().getTocity());
		clickWebelement(pom.getHome().getToselect());
	}

	@Test(dependsOnMethods = "select")
	public static void date() {
		clickWebelement(pom.getHome().getDeparture());
		clickWebelement(pom.getHome().getSearch());
	}

	@Test(dependsOnMethods = "date")
	public static void priceDetails() {
		clickWebelement(pom.getHome().getClose());
		clickWebelement(pom.getHome().getView_price());
		clickWebelement(pom.getHome().getBook_now());

		windowhandle();
	}

	@Test(dependsOnMethods = "priceDetails")
	public static void details() throws Exception {

		js_scrollDown();
		js_scrollDown();
		clickWebelement(pom.getDet().getNo());
		js_scrollDown();
		isEnabled(pom.getDet().getAdd_adult());
		isDisplayed(pom.getDet().getAdd_adult());
		explicit_wait("clickable", 10, pom.getDet().getAdd_adult());
		clickWebelement(pom.getDet().getName());
		inputValues(pom.getDet().getName(), "abc");
		clickWebelement(pom.getDet().getGender());
		clickWebelement(pom.getDet().getCountry_code());
		clickWebelement(pom.getDet().getMobile_no());
		inputValues(pom.getDet().getMobile_no(), "7448696295");
		clickWebelement(pom.getDet().getMail());
		inputValues(pom.getDet().getMail(), "rvmkalamelu@gmail.com");
		isEnabled(pom.getDet().getContinue_btn());
		isDisplayed(pom.getDet().getContinue_btn());
		clickWebelement(pom.getDet().getConfirmMail());
		explicit_wait("visibility", 100, pom.getDet().getContinue_btn());
		
	
		clickWebelement(pom.getDet().getGot_it());
		explicit_wait("visibility", 100, pom.getDet().getContinue_btn());
		screenshot("FromTestNG");
		clickWebelement(pom.getDet().getConfirm());
		isEnabled(pom.getDet().getChoose());
		isDisplayed(pom.getDet().getChoose());
		explicit_wait("clickable", 10,pom.getDet().getChoose());
		clickWebelement(pom.getDet().getSeat_no());
		clickWebelement(pom.getDet().getSeat_continue());
		js_scrollDown();
		js_scrollDown();
		clickWebelement(pom.getDet().getMeal_continue());
		Thread.sleep(5000);
		screenshot("final testng page");
	
	}

	@AfterSuite()
	public static void exit() {
		quit();

	}

}
