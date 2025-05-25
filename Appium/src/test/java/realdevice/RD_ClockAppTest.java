package realdevice;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class RD_ClockAppTest {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() throws Exception {
		System.out.println("connect with device and launch App");
		
		
		String appiumServer = "http://localhost:4723/wd/hub";
		
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		//devicesDetails
//		caps.setCapability("udid", "c60c1a73");							//deviceID  ----- adb devices
//		caps.setCapability("platformName", "android");
		
		caps.setCapability("udid", "emulator-5554");							//deviceID  ----- adb devices
		caps.setCapability("platformName", "android");
//		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
//		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "GameMachine");
//		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//		caps.setCapability(MobileCapabilityType.NO_RESET, true);
		
		
		//AppDetails ---- APK info
//		caps.setCapability("appPackage", "com.google.android.calculator");		
//		caps.setCapability("appActivity", "com.android.calculator2.Calculator");	
		
		
//		//clock
//		adb shell dumpsys window | find "mCurrentFocus"
//		  mCurrentFocus=Window{1156954 u0 com.coloros.alarmclock/com.oplus.alarmclock.AlarmClock}

//		  mCurrentFocus=Window{5478458 u0 com.google.android.deskclock/com.android.deskclock.DeskClock}
		
		caps.setCapability("appPackage", "com.google.android.deskclock");		
		caps.setCapability("appActivity", "com.android.deskclock.DeskClock");
		
		
		//AppDetails   ---- appPackage and appActivity
		//command 
//		adb shell dumpsys window | find "mCurrentFocus"
//		  mCurrentFocus=Window{e5a2295 u0 com.google.android.calculator/com.android.calculator2.Calculator}
		
		
		driver = new AppiumDriver<MobileElement>(new URL(appiumServer), caps);
		
		
		
	}
	
	
	@AfterTest
	public void teardown() {
		System.out.println("closeApp");
		
		
	}
	
	
	@Test
	public void verifyAddFeature() {
		
		System.out.println("verify add test feature.....");
		
		driver.findElement(By.id("com.google.android.deskclock:id/fab")).click();
		
		
	}
	
	
	

}







