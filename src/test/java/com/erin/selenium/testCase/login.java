package com.erin.selenium.testCase;

import java.sql.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.erin.selenium.base.BasePage;
import com.erin.selenium.base.DriverBase;
import com.erin.selenium.business.LoginPro;

public class login extends CaseBase{
	public DriverBase driver;
	public LoginPro loginpro;
	static Logger logger = Logger.getLogger(login.class);//log4j引用
	public login() {
		this.driver = InitDriver("chrome");
		loginpro = new LoginPro(driver);
	}
	 
	@Test
	public void getLoginHome() {
		driver.get("http://www.imooc.com");
		driver.findElement(By.id("js-signin-btn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test (dependsOnMethods = {"getLoginHome"})
	public void testLogin() {
		logger.debug("登录开始-------------------------");
		loginpro.login("18859218264", "5509945cyp");
	}
	
//	/*
//	 * 获取课程信息
//	 */
//	public String getCourseText(WebElement element) {
//		return element.getText();
//	}
	
	/*
	 * 下单流程
	 */
	public void buyCourse() {
		driver.get("https://coding.imooc.com/class/309.html");
		String courseDetial =	driver.findElement(By.className("path")).findElement(By.tagName("span")).getText();
		driver.findElement(By.id("buy-trigger")).click();
		this.testLogin();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("buy-trigger")).click();
		driver.findElement(By.linkText("提交订单")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String orderText =  driver.findElement(By.className("order")).getText();
		if(orderText !=null) {
			String orderString = driver.findElement(By.className("item")).findElement(By.className("left")).findElement(By.tagName("dt")).getText();
			Assert.assertEquals(courseDetial, orderString,"购买的商品信息不一致");
		}
		driver.stop();	
	}
	
	
	/*
	 * 下单流程
	 */
	@Test (dependsOnMethods= {"testLogin"})
	public void downOrder() {
		driver.get("https://coding.imooc.com/class/309.html");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.buyCourseNow();
		this.testLogin();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentText = this.buyCourseNow();
		System.out.println("当前课程信息："+currentText);
		this.sureOrder();
		this.getOrder();
		String orderCourseText = this.getOrderCourse();
		System.out.println("订单页面课程信息"+orderCourseText);
		if (currentText.equals(orderCourseText)) {
			System.out.println("下单成功");
		}
	}
	
	
	/*
	 * 获取element
	 * 也可以是父element
	 */
	public WebElement getElement(By by) {
		return driver.findElement(by);
	}
	
	/*
	 * 通过父节点，获取子节点
	 */
	public WebElement getElement(WebElement element,By by) {
		return element.findElement(by);
	}
	
	/*
	 * 获取课程信息
	 */
	public String getCourseText(WebElement element) {
		return	element.getText();
	}
	/*
	 * 立即购买，然后返回课程信息
	 */
	public String buyCourseNow() {
		WebElement element = this.getElement(By.className("path"));
		WebElement elementNode = this.getElement(element,By.tagName("span"));//子节点
		String currentText = this.getCourseText(elementNode);
		this.getElement(By.id("buy-trigger")).click();
		return currentText;
	}
	
	/*
	 *  点击确认订单
	 */
	
	public void sureOrder() {
		this.getElement(By.linkText("提交订单")).click();
	}
	
	/*
	 * 获取订单号TEXT
	 */
	public String getOrder() {
		String orderText = this.getCourseText(this.getElement(By.className("order")));
		return orderText;
	}
	/*
	 * 获取支付中心商品信息
	 */
	public String getOrderCourse() {
		WebElement element = this.getElement(By.className("item-left"));
		WebElement elementNode = this.getElement(element,By.className("dt"));
		return	this.getCourseText(elementNode);
	}
	
}



