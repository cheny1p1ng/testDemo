package com.erin.selenium.business;

import com.erin.selenium.base.DriverBase;
import com.erin.selenium.handle.OrderPayPageHandle;

public class OrderPayPagePro {
	public DriverBase driver;
	public OrderPayPageHandle orderPayPageHandle;
	public OrderPayPagePro(DriverBase driver) {
		this.driver = driver;
		orderPayPageHandle = new OrderPayPageHandle(driver);
	}
	/*
	 * 根据课程、订单判断跳转到支付页面
	 */
	public void orderPayPro() {
		String orderName = orderPayPageHandle.getOrderName();
		String courseName = orderPayPageHandle.getOrderCourseName();
		if(orderName!=null && courseName!=null ) {
			orderPayPageHandle.clickAliPay();
			orderPayPageHandle.clickPayElement();
		}
	}
	
}
