package com.erin.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import chen.testDemo.ProUtil;
/**
 * 基类封装
 */
public class BasePage {
	public DriverBase driver1;
	
	public BasePage(DriverBase driver) {
		this.driver1 = driver;
	}
	
	
	/**
	 * 定位Element
	 */
	public WebElement element(By by) {
		WebElement element = driver1.findElement(by);
		return element;
	}
	
	/**
	 * 封装点击
	 */
	
	public void click(WebElement element) {
		if(element!=null) {
			element.click();
		}else {
			System.out.println("元素没有定位到，点击失败");
		}
	}
	
	/**
	 * 封装输入
	 */
	public void sendKeys(WebElement element,String value) {
		if(element!=null) {
			element.sendKeys(value);
		}else {
			System.out.println(element+"元素没有定位到，输入失败"+value);
		}
	}
	
	/**
	 * 判断元素是否显示
	 */
	
	public boolean assertElementIs(WebElement element) {
		return element.isDisplayed();
	}
	
	/**
	 * 是否输入
	 */
	
	/**
	 * 是否有效
	 */
	
	/**
	 * 是否选中
	 */
	
	
	public By byStr(String username) {
		ProUtil proUtil = new ProUtil("element.properties");
		String locator =  proUtil.getPro(username);
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		if(locatorType.equals("id")) {
			return By.id(locatorValue);
		}else if(locatorType.equals("name")){
			return By.name(locatorValue);
		}else if(locatorType.equals("className")) {
			return By.className(locatorValue);
		}else if(locatorType.equals("tagName")) {
			return By.tagName(locatorValue);
		}
		else if(locatorType.equals("linkTetx")) {
			return By.linkText(locatorValue);
		}else {
			return By.xpath(locatorValue);
		}
	}
	
}


