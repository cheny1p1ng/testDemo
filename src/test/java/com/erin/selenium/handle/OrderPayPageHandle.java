package com.erin.selenium.handle;

import com.erin.selenium.base.DriverBase;
import com.erin.selenium.page.orderPayPage;

public class OrderPayPageHandle {

	public DriverBase driver;
	public orderPayPage orderPayPage;
	public OrderPayPageHandle(DriverBase driver) {
		this.driver = driver;
		orderPayPage = new orderPayPage(driver);
	}
	/*
	 * 获取订单文字
	 */
	public String getOrderName() {
		return orderPayPage.getText(orderPayPage.getOrderNumElement());
	}
	/*
	 * 获取课程名称
	 */
	public String getOrderCourseName() {
		return orderPayPage.getText(orderPayPage.getOrderCourserNameElement());
	}
	/*
	 * 点击支付宝支付
	 */
	public void clickAliPay() {
		orderPayPage.click(orderPayPage.getAlipayElement());
	}
	/*
	 * 点击立即支付
	 */
	public void clickPayElement() {
		orderPayPage.click(orderPayPage.getOrderPayElement());
	}
	
	
	
	
	
	
	
	
	
}
