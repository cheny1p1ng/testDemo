package com.erin.selenium.page;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebElement;

import com.erin.selenium.base.DriverBase;

public class HomePage extends BasePage{

	public DriverBase driver;
	public HomePage(DriverBase driver) {
		super(driver);
	}
	/*
	 * 获取点击登录element
	 */
	public WebElement getLoginElement() {
		return element(byStr("login"));
	}
	/*
	 * 获取实战element
	 */
	public WebElement getCodingElement() {
		return nodeElement(byStr("tophead"), byStr("coding"));
	}
	/*
	 * 获取用户名信息element
	 */
	public WebElement getUserNameElement() {
		action(element(byStr("header")));
		return element(byStr("nameInfo"));
	}
}
