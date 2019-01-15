package com.erin.selenium.page;

import org.openqa.selenium.WebElement;

import com.erin.selenium.base.DriverBase;

/*
 * 购物车操作层
 */
public class CoursePage extends BasePage{

	public CoursePage(DriverBase driver) {
		super(driver);
		
	}
	/*
	 * 获取立即购买按钮element
	 */
	public WebElement getBuytriggerElement() {
		return element(byStr("buyNow"));
	}
	/*
	 * 获取添加购物车element
	 */
	public WebElement getAddCartElement() {
		return element(byStr("addCart"));
	}
	/*
	 * 获取右上角购物车element
	 */
	public WebElement getShopCartElement() {
		return element(byStr("shopCart"));
	}
	/*
	 * 获取购物车数量
	 */
	public WebElement getShopCart() {
		return element(byStr("cartNum"));
	}
	/*
	 * 获取课程详情页面左上角课程名element
	 */
	public WebElement getCourseNameElement() {
		return nodeElement(byStr("courseInfo"), byStr("courseInfoText"));
	}
	/*
	 * 通过字符节点定位已购买弹窗确定按钮
	 */
	public WebElement getReadyBuy() {
		return nodeElement(byStr("readybuySure"), byStr("readybuySureNode"));
	}
	public WebElement getGoPayElement() {
		// TODO Auto-generated method stub
		return nodeElement(byStr("shopgopay"), byStr("shopgopayNode"));
	}
}
