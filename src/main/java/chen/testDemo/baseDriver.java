package chen.testDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseDriver {
	public WebDriver driver;
	private String className;
	private String methodName;
	//构造方法
//	public baseDriver() {
//		System.setProperty("webdriver.chrome.driver", "G:\\\\seleniumdriver\\\\chromedriver.exe");
//		driver = new ChromeDriver();
//	}
	public baseDriver(WebDriver driver, String className, String methodName) {
		this.driver = driver;
		this.className = className;
		this.methodName = methodName;
	}
	


	/**
	 * 截图
	 */
	public void takeScreenShot() {
		long date = System.currentTimeMillis();//获取时间戳
		String path = String.valueOf(date);
		String curpath = System.getProperty("user.dir");
		path = path+".png";
		String screenPath = curpath +"/test-output/screenShot" +"/"+className+"_"+methodName+"_"+path ;
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File(screenPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
 
}
