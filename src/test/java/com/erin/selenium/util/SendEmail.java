package com.erin.selenium.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
	public static void sendToEmail(String content) {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.163.com");//设置邮箱服务器
		email.setAuthentication("chenyiping5509@163.com", "5509945cyp,.");
		try {
			email.setFrom("chenyiping5509@163.com");
			email.addTo("841123402@qq.com");
			email.setSubject("selenium自动化测试邮件");
			email.setContent(content,"text/html;charset=utf-8");//也可以用setMassege,但可能会乱码
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		sendToEmail("测试邮件");
	}
}
