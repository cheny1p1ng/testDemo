package com.erin.selenium.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
@Parameters("browser")
public class SelectDriver {
	public WebDriver driverName(String browser) {
		if(browser.equalsIgnoreCase("fireFox")) {
			System.setProperty("webdriver.firefox.driver", "G:\\\\seleniumdriver\\\\geckodrive-v0.23.0r.exe");
			return new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "G:\\\\seleniumdriver\\\\chromedriver.exe");
			return new ChromeDriver();
		}else {
			System.setProperty("webdriver.ie.driver", "G:\\\\seleniumdriver\\\\IEDriverServer64.exe");
			return new InternetExplorerDriver();
		}
	}
}
