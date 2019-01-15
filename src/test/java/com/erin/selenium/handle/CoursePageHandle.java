package com.erin.selenium.handle;

import org.openqa.selenium.WebElement;

import com.erin.selenium.base.DriverBase;
import com.erin.selenium.page.CoursePage;

public class CoursePageHandle {

	public DriverBase driver;
	public CoursePage coursePage;
	public CoursePageHandle(DriverBase driver) {
		this.driver = driver;
		coursePage = new CoursePage(driver);
	}
	/*
	 * 点击立即购买按钮
	 */
	public void clickBuyNow() {
		coursePage.click(coursePage.getBuytriggerElement());
	}
	/*
	 * 点击添加购物车按钮
	 */
	public void clickAddCart() {
		coursePage.click(coursePage.getAddCartElement());
	}
	/*
	 * 点击右上角购物车
	 */
	public void clickShopCart() {
		coursePage.click(coursePage.getShopCartElement());
	}
	/*
	 *  获取购物车数量
	 */
	public String getShopCartNum() {
		WebElement element = coursePage.getShopCart();
		return coursePage.getText(element);
	}
	/*
	 * 获取课程名称
	 */
	public String getCourseName() {
		WebElement element = coursePage.getCourseNameElement();
		return coursePage.getText(element);
	}
	/*
	 * 去结算
	 */
	public void clickGopay() {
		coursePage.click(coursePage.getGoPayElement());
	}
	/*
	 * 点击已经购买弹窗的确定按钮
	 */
	public void clickReadBuy() {
		coursePage.click(coursePage.getReadyBuy());
	}
}
