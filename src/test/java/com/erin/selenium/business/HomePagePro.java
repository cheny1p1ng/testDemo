package com.erin.selenium.business;

import com.erin.selenium.base.DriverBase;
import com.erin.selenium.handle.HomePageHandle;

public class HomePagePro {
	public HomePageHandle hph;
	public HomePagePro(DriverBase driver) {
		hph = new HomePageHandle(driver);
	}
	/*
	 * 点击登录按钮
	 */
	public void clickLoginButton() {
		hph.clickLogin();
	}
	/*
	 * 点击实战按钮
	 */
	public void clickCodingLink() {
		hph.clickCoding();
	}
	/*
	 * 根据用户名判断登录信息是否正确
	 */
	public Boolean AssertLogin(String username) {
		if(hph.getUserName().equals(username)) {
			return true;
		}else {
			return false;
		}
	}
}
