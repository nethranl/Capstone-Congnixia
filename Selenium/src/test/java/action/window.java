
package action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class window {

    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testMultipleWindows() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");

        // Click "New Window" using JavaScript (due to ad iframe interference)
        WebElement button = driver.findElement(By.id("windowButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

        // Add delay to observe the new window launch
        Thread.sleep(3000);  // 3 seconds delay

        String parentWindow = driver.getWindowHandle();

        // Switch to the new window
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Add another short delay to observe the new window content
        Thread.sleep(2000);  // 2 seconds delay

        // Get and print text in new window
        String heading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Text in new window: " + heading);

        // Close new window and return to parent
        driver.close();
        driver.switchTo().window(parentWindow);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
