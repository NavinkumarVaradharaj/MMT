package com.testrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Project.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageObjectManager extends BaseClass {

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	private HomePage home;
	private Details det;

	public HomePage getHome() {
		home = new HomePage(driver);
		return home;
	}

	public Details getDet() {
		det = new Details(driver);
		return det;
	}

}
