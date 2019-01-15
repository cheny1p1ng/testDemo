package com.erin.selenium.page;

import org.openqa.selenium.WebElement;

import com.erin.selenium.base.DriverBase;

public class SureOrderPage extends BasePage{

	public SureOrderPage(DriverBase driver) {
		super(driver);
	}
	/*
	 * 获取提交订单按钮
	 */
	public WebElement getSubOrderElement() {
		return element(byStr("sureOrder"));
	}
	/*
	 * 
	 */
	
}
