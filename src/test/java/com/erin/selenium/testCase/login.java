package com.erin.selenium.testCase;

import java.sql.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.erin.selenium.base.DriverBase;
import com.erin.selenium.business.LoginPro;

public class login extends CaseBase{
	public DriverBase driver;
	public LoginPro loginpro;
	static Logger logger = Logger.getLogger(login.class);//log4j引用
	public login() {
		this.driver = InitDriver("chrome");
		loginpro = new LoginPro(driver);
	}
	 
	@Test
	public void getLoginHome() {
		driver.get("http://www.imooc.com");
		driver.findElement(By.id("js-signin-btn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test (dependsOnMethods = {"getLoginHome"})
	public void testLogin() {
		logger.debug("登录开始-------------------------");
		loginpro.login("18859218264", "5509945cyp");
	}
	
}
