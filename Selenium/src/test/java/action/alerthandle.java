package action;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class alerthandle {

    public WebDriver driver;

    @BeforeTest
    public void launchApp() {
        System.out.println("========launchApp==========");

        // No need to set System property if msedgedriver.exe is in PATH
        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
    }

    @AfterTest
    public void closeApp() {
        System.out.println("========closeApp==========");
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testHandleAlert() {
        try {
            WebElement alertButton = driver.findElement(By.cssSelector(".btn.btn-danger"));
            alertButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            Thread.sleep(2000);
            alert.accept();
            System.out.println("Alert accepted successfully!");
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + e.getMessage());
        }
    }
}
