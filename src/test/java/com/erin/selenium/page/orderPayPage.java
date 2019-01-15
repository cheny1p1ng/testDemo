package com.erin.selenium.page;

import org.openqa.selenium.WebElement;

import com.erin.selenium.base.DriverBase;

public class orderPayPage extends BasePage{
	public DriverBase driver;
	public orderPayPage(DriverBase driver) {
		super(driver);
	}
	/*
	 * 获取订单号码element
	 */
	public WebElement getOrderNumElement() {
		return element(byStr("order"));
	}
	/*
	 * 返回课程名称elemen
	 */
	public WebElement getOrderCourserNameElement() {
		return nodeElement(byStr("orderCourse"),byStr("orderCourseNode"));
	}
	/*
	 * 获取支付方式(支付宝)
	 */
	public WebElement getAlipayElement() {
		return element(byStr("alipay"));
	}
	/*
	 * 获取点击立即支付按钮
	 */
	public WebElement getOrderPayElement() {
		return element(byStr("orderpay"));
	}
}
