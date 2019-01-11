package chen.testDemo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestngListenerScreenShot.class})
public class Login {

	//public WebDriver driver;
	

	protected static WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}
	public void InitDriver() {
		System.setProperty("webdriver.chrome.driver", "G:\\\\seleniumdriver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.imooc.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("js-signin-btn")).click();	
	}

	public void loginScript(String username,String paddword) throws Exception{
		this.InitDriver();
		//String loginButtonEle = "moco-btn-red";
	//	String emailElement = "email";
//		String passWordElement = "password";
//		String headerElement = "header-avator";
//		String nameElement = "name";
//		String ById = "id";
//		String ByName = "name";
//		String ByClassName = "className";
		
		Thread.sleep(2000);
		WebElement user = this.element(this.byStr("userName"));
		user.isDisplayed();//是否显示
		WebElement password = this.element(this.byStr("passWord"));
		password.isDisplayed();
		WebElement loginButton = this.element(this.byStr("loginButtonEle"));
			loginButton.isDisplayed();
			user.sendKeys(username);
			password.sendKeys(paddword);
			loginButton.click();
			Thread.sleep(2000);
			
//		if (doesWebElementExist(driver, this.byStr("verifyTip"))) {
//			WebElement tip = this.element(this.byStr("verifyTip"));
//			tip.isDisplayed();
//			String verifyTip = tip.getText();
//			System.out.println("登录失败"+verifyTip);
//			driver.close();
//		} else {
			WebElement header = this.element(this.byStr("headerElement"));
			header.isDisplayed();
			Actions action = new Actions(driver);
			action.moveToElement(header).perform();
			Thread.sleep(1000);
			WebElement nameText = this.element(this.byStr("nameElement"));
			nameText.isDisplayed();
			String userInfo = nameText.getText();
			if (userInfo.equals("慕姐8535910")) {
				//this.takeScreenShot();
				System.out.println("登录成功");
			} else {
				System.out.println("登录失败");
				driver.close();
			}
	}	
			
//	}
	
	
	/**
	 * 
	 *验证是否存在此定位元素
	 */
	public boolean doesWebElementExist(WebDriver driver, By selector) {

		try {
			driver.findElement(selector);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/**  封装By
	 * 
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
	
	/**  封装Element
	 * 
	 */
	public WebElement element(By by) {
		WebElement ele = driver.findElement(by);
		return ele;
	}
	
	
	
//	/**
//	 * 截图
//	 */
//	
//	public void takeScreenShot() {
//		long date = System.currentTimeMillis();//获取时间戳
//		String path = String.valueOf(date);
//		String curpath = System.getProperty("user.dir");
//		path = path+".png";
//		String screenPath = curpath +"/test-output/screenShot" +"/"+path ;
//		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(screen, new File(screenPath));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	@Test
	public void loginpage() throws Exception {
		this.loginScript("18859218264","5509945cyp");	
	}
	
//	public static void main(String[] args) throws Exception{
//		Login login = new Login();
//		login.loginScript("18859218264","5509945cyp");
//		/**
//		 * key-value
//		 * username-password
//		 */
//		HashMap<String, String> user = new HashMap<String, String>();
//		user.put("18859218264", "55209945cyp");
//		user.put("841123402@qq.com", "test1234");
//		Iterator userss = user.entrySet().iterator();//迭代器
//		while(userss.hasNext()) {
//			Map.Entry entry = (Map.Entry) userss.next();
//			String username = entry.getKey().toString();
//			String password = entry.getValue().toString();
//			login.loginScript(username, password);
//		}
//	}
	
}
