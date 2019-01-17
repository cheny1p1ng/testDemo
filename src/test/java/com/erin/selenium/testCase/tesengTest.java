package com.erin.selenium.testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tesengTest {
	
	@BeforeClass
	public void test01() {
		System.out.println("BeforeClass---------test01");
	}
	@BeforeMethod
	public void test02() {
		System.out.println("BeforeMethod----------test02");
	}
	@AfterMethod
	public void test03() {
		System.out.println("AfterMethod--------------test03");
	}
	@AfterClass
	public void test04() {
		System.out.println("AfterClass--------------test04");
	}
	@Test
	public void test() {
		System.out.println("test--------------test05");
	}
	@Test
	public void test002() {
		System.out.println("test002--------------test05");
	}

}
