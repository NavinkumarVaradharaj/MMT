package com.testrunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class Details extends Base{
	
	public Details(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "(//span[@class=\"darkText lightFont fontSize14\"])[2]")
	private WebElement no;
	
	@FindBy(xpath = "//button[@class='addTravellerBtn']")
	private WebElement add_adult;
	
	@FindBy(xpath = "//input[@placeholder=\"First & Middle Name\"]")
	private WebElement name;
	
	@FindBy(xpath = "//input[@value=\"FEMALE\"]")
	private WebElement gender;
	
	@FindBy(xpath = "//div[@class=\"dropdown__control css-yk16xz-control\"]")
	private WebElement country_code;
	
	@FindBy(xpath = "(//input[@class=\"tvlrInput \"])[3]")
	private WebElement mobile_no ;
	
	@FindBy(xpath = "(//input[@class=\"tvlrInput \"])[4]")
	private WebElement mail;
	
	@FindBy(xpath = "//div[@class='oneCard-element']//following::button[@class='lato-black button buttonPrimary extraPadBtn fontSize16 ']")
	private WebElement continue_btn;
	
	@FindBy(xpath = "//button[text()='Got it']")
	private WebElement got_it;
	
	@FindBy(xpath = "//button[text()='CONFIRM']")
	private WebElement confirm;
	
	@FindBy(xpath = "//div[@class='emailId']")
	private WebElement confirmMail;
	
	@FindBy(xpath = "//span[@class=\"fontSize16 linkText\"]")
	private WebElement choose;
	
	@FindBy(xpath = "(//div[@class=\"seatBlock pointer\"])[65]")
	private WebElement seat_no;

	@FindBy(xpath = "//button[@class=\"lato-black button buttonPrimary extraPadBtn fontSize16 \"]")
	private WebElement seat_continue;
	
	@FindBy(xpath = "//button[@class=\"lato-black button buttonPrimary extraPadBtn fontSize16 \"]")
	private WebElement meal_continue;
	
	
	public WebElement getConfirm() {
		return confirm;
	}


	public WebElement getChoose() {
		return choose;
	}


	public WebElement getSeat_no() {
		return seat_no;
	}


	public WebElement getSeat_continue() {
		return seat_continue;
	}


	public WebElement getMeal_continue() {
		return meal_continue;
	}


	public WebElement getConfirmMail() {
		return confirmMail;
	}


	public WebElement getNo() {
		return no;
	}


	public WebElement getAdd_adult() {
		return add_adult;
	}


	public WebElement getName() {
		return name;
	}


	public WebElement getGender() {
		return gender;
	}


	public WebElement getCountry_code() {
		return country_code;
	}


	public WebElement getMobile_no() {
		return mobile_no;
	}


	public WebElement getMail() {
		return mail;
	}


	public WebElement getContinue_btn() {
		return continue_btn;
	}


	public WebElement getGot_it() {
		return got_it;
	}
	
	
	

	}


