package com.erin.selenium.business;

import com.erin.selenium.base.DriverBase;
import com.erin.selenium.handle.loginPageHandle;

/**
 * 业务层
 */
public class LoginPro {
	public loginPageHandle lph;
	public LoginPro(DriverBase driver) {
		lph = new loginPageHandle(driver);
	}
	public void login(String username,String password) {
	
		if(lph.assertLoginPage()) {
			lph.sendKeysUser(username);
			lph.sendKeysPassword(password);
			//lph.clickAutoSignin();
			lph.clickLoginButton();
		}else {
			System.out.println("页面不存在或者状态不正确");
		}
	}
	
}
