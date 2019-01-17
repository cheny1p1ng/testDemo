package com.erin.selenium.testCase;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.erin.selenium.base.DriverBase;

public class testCourseList extends CaseBase{
	public DriverBase driver;
	
	public testCourseList(){
		this.driver = InitDriver("chrome");
	}
	
	@Test
	public void CourseList() {
	driver.get("http://coding.imooc.com/");
			//driver.get("https://coding.imooc.com/?c=fe");
		driver.winMax();
		java.util.List<String> listString = this.listElement();
		for(int i =0 ;i<listString.size();i++) {
			String stringElement = listString.get(i);
			WebElement close = driver.findElement(By.className("js-close"));
			if(close.isDisplayed()) {
				close.click();
			}
			By a = By.xpath("//*[contains(text(),'"+stringElement.substring(0, 10)+"')]");
			driver.WebDriverWait(10,a);
			WebElement context = driver.findElement(a);
			context.click();
			driver.back();
		}
	
	}
	
	/*
	 * 获取所有课程的List
	 */
	
	public java.util.List<String> listElement(){
		java.util.List<String> listString = new ArrayList<String>();
		WebElement element = driver.findElement(By.className("shizhan-course-list"));
		java.util.List<WebElement> listElement =  element.findElements(By.className("shizhan-course-wrap"));
		for(WebElement el:listElement) {
			listString.add(el.findElement(By.className("shizan-desc")).getText());
		}
		return listString;
	}
}
