package com.erin.selenium.base;

import org.openqa.selenium.WebElement;
/**
 * 获取元素
 */
public class loginPage extends BasePage{

	public loginPage(DriverBase driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 获取用户名输入框
	 */
	
	public WebElement getUserElement() {
		return element(byStr("userName"));
	}
	/**
	 *  获取密码输入框Element
	 */
	
	public WebElement getPassWordElemnt() {
		return element(byStr("passWord"));
	}
	
	/**
	 * 获取登录按钮element
	 */
	
	public WebElement getLoginButtonElement() {
		return element(byStr("loginButtonEle"));
	}
	
	/**
	 * 获取自动登录element
	 */
	
	public WebElement getAutoSignElement() {
		return element(byStr("autoSignin"));
	}
}
