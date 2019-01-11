package com.erin.selenium.handle;

import com.erin.selenium.base.DriverBase;
import com.erin.selenium.base.loginPage;
/**
 * 操作层
 */
public class loginPageHandle {
	public DriverBase driver;
	public loginPage lp;
	public loginPageHandle(DriverBase driver) {
		this.driver = driver;
		lp = new loginPage(driver);
	}
	
/**
 * 输入用户名
 */
	public void sendKeysUser(String username) {
		lp.sendKeys(lp.getUserElement(), username);
	}
	
	/**
	 * 输入密码
	 */
	public void sendKeysPassword(String password) {
		lp.sendKeys(lp.getPassWordElemnt(), password);
	}
	
	/**
	 * 点击登录
	 */
	public void clickLoginButton() {
		lp.click(lp.getLoginButtonElement());
	}
	
	/**
	 * 点击自动登录
	 */
	public void clickAutoSignin() {
		lp.click(lp.getAutoSignElement());
	}
	/*
	 * 判断是否是登录页面
	 * 
	 */
	
	public boolean assertLoginPage() {
	 return	lp.assertElementIs(lp.getUserElement());
	}
}
