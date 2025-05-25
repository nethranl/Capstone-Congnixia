package tests1;

import base.basetest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages1.loginpage;

import java.time.Duration;

public class logintest extends basetest {

    @Test
    public void validLoginTest() {
        loginpage login = new loginpage(driver);

        // Step 1: Login
        login.login("Admin", "admin123");
        String loginUrl = driver.getCurrentUrl();
        log.info("Logged in. URL: " + loginUrl);
        Assert.assertTrue(loginUrl.contains("dashboard"), "Dashboard not reached after login");

        // Step 2: Navigate to Admin > User Management > Users
        login.goToUserManagement();
        log.info("Navigated to User Management section.");

        // Step 3: Click Add button
        login.clickAddButton();
        log.info("Clicked on Add button.");

        // Step 4: Fill user details
        login.selectUserRoleAdmin();
        login.enterEmployeeName("Admin ");
        login.selectStatusEnabled();
        login.enterUsername("Rahul2338");
        login.enterPassword("Orange12");

        // Step 5: Save
        login.clickSave();
        log.info("Clicked Save for new user.");

        // Step 6: Validate redirection to user list page (wait up to 20 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        boolean redirected = wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertTrue(redirected, "User was not redirected back to user list page after saving.");

        log.info("User added successfully. Redirected to: " + driver.getCurrentUrl());

        // Step 7: Logout
        login.logout();
        log.info("Logged out successfully.");

        // Final validation
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Did not redirect to login page after logout.");
    }
}
