package com.erin.selenium.testCase;

import java.sql.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.erin.selenium.base.DriverBase;
import com.erin.selenium.business.CoursePagePro;
import com.erin.selenium.business.HomePagePro;
import com.erin.selenium.business.LoginPro;
import com.erin.selenium.business.OrderPayPagePro;
import com.erin.selenium.business.SureOrderPagePro;
import com.erin.selenium.handle.HomePageHandle;
import com.erin.selenium.page.BasePage;
import com.erin.selenium.util.SendEmail;

public class login extends CaseBase{
	public DriverBase driver;
	public LoginPro loginpro;
	public CoursePagePro cpp;
	public HomePagePro hph;
	public SureOrderPagePro sopp;
	public OrderPayPagePro opp;
	static Logger logger = Logger.getLogger(login.class);//log4j引用
	@Parameters("browser") //多浏览器兼容
	@BeforeClass
	public void loginTest() {
		this.driver = InitDriver("chrome");
		loginpro = new LoginPro(driver);
		cpp= new CoursePagePro(driver);
		hph= new HomePagePro(driver);
		sopp = new SureOrderPagePro(driver);
		opp = new OrderPayPagePro(driver);
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
	@Parameters({"userName","passWord"})
	public void testLogin(String userName,String passWord) {
		logger.debug("登录开始-------------------------");
		loginpro.login(userName, passWord);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.winMax();
		driver.findElement(By.linkText("实战课程")).click();
		driver.findElement(By.className("shizan-name")).click();
		//driver.get("https://coding.imooc.com/class/309.html");
	}
	
	
	/*
	 *  立即购买
	 */
	@Test(dependsOnMethods= {"testLogin"})
	public void TestAddCart() {
		cpp.buyNow();
	}
	/*
	 * 提交订单
	 */
	@Test(dependsOnMethods= {"TestAddCart"})
	public void TestSureOrder() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sopp.sureOrder();
	}
	/*
	 * 跳转支付页面
	 */
	@Test(dependsOnMethods= {"TestSureOrder"})
	public void TestGoPay() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		opp.orderPayPro();
		SendEmail.sendToEmail("测试结束");
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
//	public void buyCourse() {
//		driver.get("https://coding.imooc.com/class/309.html");
//		String courseDetial =	driver.findElement(By.className("path")).findElement(By.tagName("span")).getText();
//		driver.findElement(By.id("buy-trigger")).click();
//		this.testLogin();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		driver.findElement(By.id("buy-trigger")).click();
//		driver.findElement(By.linkText("提交订单")).click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		String orderText =  driver.findElement(By.className("order")).getText();
//		if(orderText !=null) {
//			String orderString = driver.findElement(By.className("item")).findElement(By.className("left")).findElement(By.tagName("dt")).getText();
//			Assert.assertEquals(courseDetial, orderString,"购买的商品信息不一致");
//		}
//		driver.stop();	
//	}
	
	
//	/*
//	 * 下单流程
//	 */
//	@Test (dependsOnMethods= {"testLogin"})
//	public void downOrder() {
//		driver.get("https://coding.imooc.com/class/309.html");
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		this.buyCourseNow();
//		this.testLogin();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String currentText = this.buyCourseNow();
//		System.out.println("当前课程信息："+currentText);
//		this.sureOrder();
//		this.getOrder();
//		String orderCourseText = this.getOrderCourse();
//		System.out.println("订单页面课程信息"+orderCourseText);
//		if (currentText.equals(orderCourseText)) {
//			System.out.println("下单成功");
//		}
//	}
	
	
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



