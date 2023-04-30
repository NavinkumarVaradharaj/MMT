package com.testrunner;

import com.Project.BaseClass;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.Project.*;

public class TestRunner extends BaseClass {

	public static WebDriver driver;

	static PageObjectManager pom = new PageObjectManager(driver);

	public static void browserLaunch() {
		browserLaunch("chrome");
	}

	public static void launchUrl() {
		launchUrl("https://www.makemytrip.com/");
	}

	public static void select() {
		clickWebelement(pom.getHome().getFromcity());
		clickWebelement(pom.getHome().getSelectcity());
		clickWebelement(pom.getHome().getTocity());
		clickWebelement(pom.getHome().getToselect());
	}

	public static void date() {
		clickWebelement(pom.getHome().getDeparture());
		clickWebelement(pom.getHome().getSearch());
	}

	public static void priceDetails() {
		clickWebelement(pom.getHome().getClose());
		clickWebelement(pom.getHome().getView_price());
		clickWebelement(pom.getHome().getBook_now());
	
		windowhandle();
		

	}

	public static void details() throws IOException, InterruptedException {
		js_scrollDown();
		js_scrollDown();
		clickWebelement(pom.getDet().getNo());
		js_scrollDown();
		isEnabled(pom.getDet().getAdd_adult());
		isDisplayed(pom.getDet().getAdd_adult());
		explicit_wait("clickable", 10,pom.getDet().getAdd_adult());
		//action_double_click(pom.getDet().getAdd_adult());
		clickWebelement(pom.getDet().getName());
		inputValues(pom.getDet().getName(), "abc");
		clickWebelement(pom.getDet().getGender());
		clickWebelement(pom.getDet().getCountry_code());
		clickWebelement(pom.getDet().getMobile_no());
		inputValues(pom.getDet().getMobile_no(), "1234685792");
		clickWebelement(pom.getDet().getMail());
		inputValues(pom.getDet().getMail(), "rvmkalamelu@gmail.com");
		isEnabled(pom.getDet().getContinue_btn());
		isDisplayed(pom.getDet().getContinue_btn());
		clickWebelement(pom.getDet().getConfirmMail());
		explicit_wait("visibility", 100,pom.getDet().getContinue_btn());
	//	isSelected(pom.getDet().getContinue_btn());
		clickWebelement(pom.getDet().getGot_it());
		explicit_wait("visibility", 100,pom.getDet().getContinue_btn());
	//	explicit_wait("visibility", 100,pom.getDet().getGot_it());
	//	clickWebelement(pom.getDet().getSearch());
		screenshot("DetailsPage");
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
		screenshot("final page");
		quit();
	}
	
	public static void main(String args[]) throws IOException, InterruptedException {
		
		browserLaunch();
		launchUrl();
		select();
		date();
		priceDetails();
		details();
		
	}

}
