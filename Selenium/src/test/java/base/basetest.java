package base;

import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utility.ScreenshotUtil;

public class basetest {
    public WebDriver driver;
    public Logger log;

    @BeforeClass
    public void setupLogging() {
        log = Logger.getLogger("AutomationFramework");
        PropertyConfigurator.configure("testData/log4j.properties");
    }

    @BeforeMethod
    public void launchApp() {
        driver = new ChromeDriver();
        log.info("Launching browser");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com");
        log.info("Navigated to app");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            log.error("Test failed: " + result.getName());
            ScreenshotUtil.captureScreenshot(driver, result.getName());
        }
        log.info("Closing browser");
        driver.quit();
    }
}
