package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class iframeclass {

    @Test
    public void testHandleIframe() {
        WebDriver driver = new EdgeDriver();
        System.out.println("Edge browser opened successfully.");

        try {
            driver.manage().window().maximize();
            System.out.println("Browser window maximized.");

            driver.get("https://demo.automationtesting.in/Frames.html");
            System.out.println("Navigated to https://demo.automationtesting.in/Frames.html");

            WebElement singleIframeTab = driver.findElement(By.xpath("//a[@href='#Single']"));
            singleIframeTab.click();
            System.out.println("Single Iframe tab clicked.");

            Thread.sleep(2000); // Wait 2 seconds

            driver.switchTo().frame("SingleFrame");
            System.out.println("Switched to iframe.");

            WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
            inputBox.sendKeys("Hello IFrame");
            System.out.println("Text entered in iframe input box.");

            driver.switchTo().defaultContent();
            System.out.println("Switched back to main content.");

        } catch (Exception e) {
            System.out.println("Test encountered an error: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }
}
