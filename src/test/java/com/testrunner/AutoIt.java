package com.testrunner;

import java.io.IOException;

import org.openqa.selenium.By;

import com.Project.BaseClass;

public class AutoIt  extends BaseClass {

	
	public static void main(String[] args) throws IOException, InterruptedException {
		browserLaunch("chrome");
		launchUrl("https://pixlr.com/x/");
		driver.findElement(By.xpath("//img[@class='close']")).click();
		driver.findElement(By.id("welcome-open-image")).click();
		Runtime.getRuntime().exec("\"C:\\Users\\VARU\\Documents\\Autoit\\First.exe\"");
		Thread.sleep(3000);
		screenshot("AutoIT Screentshot");
		quit();
}
}