package com.erin.selenium.testCase;

import java.sql.Driver;

import com.erin.selenium.base.DriverBase;

/**
 * 
 *生成driver,所有测试类都继承此类
 *
 */
public class CaseBase {
	public DriverBase InitDriver(String browser) {
		return new DriverBase(browser);
	}
	
}
