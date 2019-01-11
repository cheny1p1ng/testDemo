package com.erin.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
	public WebDriver driverName(String browser) {
		if(browser.equalsIgnoreCase("fireFox")) {
			System.setProperty("webdriver.chrome.driver", "G:\\\\seleniumdriver\\\\geckodrive-v0.23.0r.exe");
			return new FirefoxDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "G:\\\\seleniumdriver\\\\chromedriver.exe");
			return new ChromeDriver();
		}
	}
}
