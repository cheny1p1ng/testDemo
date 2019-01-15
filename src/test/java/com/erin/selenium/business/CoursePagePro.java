package com.erin.selenium.business;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import com.erin.selenium.base.DriverBase;
import com.erin.selenium.handle.CoursePageHandle;

public class CoursePagePro {
	public DriverBase driver;
	public CoursePageHandle coursePageHandle;
	public CoursePagePro(DriverBase driver) {
		this.driver = driver;
		coursePageHandle = new CoursePageHandle(driver);
	}
	/*
	 * 添加购物车
	 */
	public void addCart() {
		int beforeNum;
		int afterNum;
		String aftercourseNum;
		String courseNum = coursePageHandle.getShopCartNum();
	
		try {
			beforeNum=Integer.valueOf(courseNum);
			System.out.println("添加购物车前为："+beforeNum);
		} catch (Exception e) {
			beforeNum=0;
		}
		coursePageHandle.clickAddCart();
		driver.switchToMode();//切换到模态框
		coursePageHandle.clickBuyNow();
		aftercourseNum = coursePageHandle.getShopCartNum();
		try {
			afterNum=Integer.valueOf(aftercourseNum);
			System.out.println("添加购物车后为："+afterNum);
		} catch (Exception e) {
			afterNum=beforeNum;
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(afterNum == beforeNum+1) {
			System.out.println("添加购物车成功");
			coursePageHandle.clickShopCart();
		}else if(afterNum>0) {
			coursePageHandle.clickShopCart();
		}
	}
	/*
	 * 点击立即购买
	 */
	public void buyNow() {
		coursePageHandle.clickBuyNow();
	}
}
