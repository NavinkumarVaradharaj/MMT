package com.Project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static void browserLaunch(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			driver = new ChromeDriver(opt); // up casting
			opt.addArguments("--incognito");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions opt = new FirefoxOptions();
			driver = new FirefoxDriver(opt); // up casting
			opt.addArguments("--incognito");
			driver.manage().window().maximize();

		}
	}

	public static void launchUrl(String url) {
		driver.get(url);

	}

	public static void close() {
		driver.close();

	}

	public static void inputValues(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void quit() {
		driver.quit();

	}

	public static void navigate(String url) {
		driver.navigate().to(url);

	}

	public static void navigate_Refresh() {
		driver.navigate().refresh();

	}

	public static void navigate_back() {
		driver.navigate().back();

	}

	public static void navigate_forward() {
		driver.navigate().forward();

	}

	public static void confirm_alert(String condition) {
		Alert a = driver.switchTo().alert();
		if (condition.equalsIgnoreCase("accept")) {
			a.accept();
		} else if (condition.equalsIgnoreCase("dismiss")) {
			a.dismiss();
		}
	}

	public static void clickWebelement(WebElement element) {
		element.click();
	}

	public static void action(WebElement element, String value) {
		Actions a = new Actions(driver);
		if(value.equalsIgnoreCase("context")) {
		a.contextClick(element).build().perform();
		}else if(value.equalsIgnoreCase("click")) {
		a.click(element).perform();
		}
	}

	public static void action_double_click(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).build().perform();
		;

	}

	public static void action_moveToElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
		;

	}

	public static void action_dragAndDrop(WebElement element) {
		Actions a = new Actions(driver);
		a.dragAndDrop(element, element).build().perform();
		;

	}

	public static void robot() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_WINDOWS);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void switchToWindow(String windowId) {
		Set<String> all_ids = driver.getWindowHandles();
		for (String itr : all_ids) {
			if (itr.equals(windowId)) {
				driver.switchTo().window(itr);

			}
		}

	}

	public static void dropDown(WebElement element, String option, String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(value));
		} else if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
	}

	public static void frames_index(int index) {
		driver.switchTo().frame(index);
	}

	public static void frames_value(String value) {
		driver.switchTo().frame(value);
	}

	public static void frames_value(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void isEnabled(WebElement element) {

		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}

	public static void isDisplayed(WebElement element) {

		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}

	public static void isSelected(WebElement element) {

		boolean selected = element.isSelected();
		System.out.println(selected);
	}

	public static void getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}

	}

	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void gettext(WebElement element) {

		System.out.println(element.getText());

	}

	public static void windowhandle() {

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> itr = windowHandles.iterator();
		itr.next();
		String tab = itr.next();
		switchToWindow(tab);
	}

	public static void js_scrollUp() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

	}

	public static void js_scrollDown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

	}
	
	public static void scroll_down_js(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments(0).scrollIntoView();",element );
	}

	public static void implicit_wait() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public static void explicit_wait(String value, long seconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);
		if (value.equalsIgnoreCase("alert accept")) {
			wait.until(ExpectedConditions.alertIsPresent()).accept();
		} else if (value.equalsIgnoreCase("alert dismiss")) {
			wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		} else if (value.equalsIgnoreCase("visibility")) {
			wait.until(ExpectedConditions.visibilityOf(element)).click();;

		} else if (value.equalsIgnoreCase("all visibility")) {
			wait.until(ExpectedConditions.visibilityOfAllElements(element));

		}else if(value.equalsIgnoreCase("clickable")) {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			
		}
	}

	public static void screenshot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("C:\\Users\\VARU\\eclipse-workspace\\MakeMyTrip\\Screen\\"+filename+".png");
		FileUtils.copyFile(src, dest1);

	}

}
