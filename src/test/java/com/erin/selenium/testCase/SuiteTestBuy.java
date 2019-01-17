package com.erin.selenium.testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.erin.selenium.base.DriverBase;
import com.erin.selenium.business.CoursePagePro;
import com.erin.selenium.page.BasePage;
import com.erin.selenium.util.HandleCookie;

/*
 * 独立购买流程，不依赖其他test
 */
public class SuiteTestBuy extends CaseBase{
	public DriverBase driver;
	public CoursePagePro cpp;
	public HandleCookie handleCookie;
	@BeforeClass
	public void beforeClass() {
		this.driver = InitDriver("chrome");
		cpp= new CoursePagePro(driver);
		handleCookie = new HandleCookie(driver);
		driver.get("https://coding.imooc.com/class/309.html");
		handleCookie.setCookie();
		driver.get("https://coding.imooc.com/class/309.html");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testBuy() {
		cpp.buyNow();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void afterClass() {
		//driver.stop();
	}
}
