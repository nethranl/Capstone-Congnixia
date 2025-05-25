package Cloud_BS;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public class HRMLoginTest_BS {
	
	
	WebDriver driver;
	public static final String USERNAME = "nethranl_UJTNi0";
	public static final String AUTOMATE_KEY = "K7yaYqJkWzCTCfA2ij79";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


	@BeforeMethod
	public void setUp() throws Exception {

		
		DesiredCapabilities caps = new DesiredCapabilities();
        
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 pro");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16");

		
//		caps.setCapability("browserName", "chromium");
		
		caps.setCapability("build", "Cognixia: iOS - v1011");
		caps.setCapability("name", "Run chrome on device - HRM app Test on cloud -iOS");

		driver = new RemoteWebDriver(new URL(URL), caps);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void closeSession() throws Exception {
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	
	@Test
	public void VerifyHRMLoginTest() {
		
		System.out.println("enter user details......");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.cssSelector("[type=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		
		
		
		
	}
	

}
