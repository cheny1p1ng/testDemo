package com.erin.selenium.testCase;

import org.testng.Assert;

/*
 * testNG里的断言
 */
public class testAssert {

	public static void main(String[] args) {
		String s =null;
		Assert.assertEquals("1", "1","这两个值不一样");//1、实际值；2、期望值；3、不一致的输出文字
		Assert.assertNotNull(s,"现在为空");
	}
}
