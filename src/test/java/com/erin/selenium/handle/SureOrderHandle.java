package com.erin.selenium.handle;

import com.erin.selenium.base.DriverBase;
import com.erin.selenium.page.SureOrderPage;

public class SureOrderHandle {
	public SureOrderPage sureorderpage;
	public DriverBase driver;
	public SureOrderHandle(DriverBase driver) {
		this.driver = driver;
		sureorderpage = new SureOrderPage(driver);
	}
	/*
	 * 点击确认订单按钮
	 */
	public void clickSubOrderElement() {
		sureorderpage.click(sureorderpage.getSubOrderElement());
	}
}
