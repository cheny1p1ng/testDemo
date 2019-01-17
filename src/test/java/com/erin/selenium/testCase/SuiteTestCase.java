package com.erin.selenium.testCase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.erin.selenium.base.DriverBase;
import com.erin.selenium.business.HomePagePro;
import com.erin.selenium.business.LoginPro;
import com.erin.selenium.util.HandleCookie;

import chen.testDemo.ProUtil;

/*
 * 独立登录流程，不依赖其他test
 */
public class SuiteTestCase extends CaseBase{
	public DriverBase driver;
	public LoginPro loginpro;
	public HomePagePro homepagepro;
	public HandleCookie handleCookie;
	ProUtil proUtil;
	@BeforeClass
	public void beforeClass() {
		this.driver = InitDriver("chrome");
		proUtil =new ProUtil("loginTest.properties");
		driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpro = new LoginPro(driver);
		homepagepro = new HomePagePro(driver);
		driver.get(proUtil.getPro("url"));
		handleCookie =new HandleCookie(driver);
	}
	
	@Test
	//@Parameters({"userName","passWord"})
	public void testLogin() {
		String userName =proUtil.getPro("userName");
		loginpro.login(proUtil.getPro("userName"),proUtil.getPro("passWord") );
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(homepagepro.AssertLogin(proUtil.getPro("yq"))) {
			System.out.println("登录成功"+userName);
			handleCookie.writeCookie();
		}
	}
	
	@AfterClass
	public void afterClass() {
		driver.stop();
	}
}
