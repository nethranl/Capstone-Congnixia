package tests1;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.basetest1;
import pages1.Registerpage;

public class RegisterTest extends basetest1 {

    @Test
    public void registerNewUser() throws InterruptedException {
        Registerpage regPage = new Registerpage(driver);

        log.info("Clicking Register link");
        regPage.clickRegisterLink();
        Thread.sleep(2000);  // Delay to observe UI

        String uniqueEmail = "abc123237" + System.currentTimeMillis() + "@gmail.com";
        log.info("Filling registration form");
        regPage.fillForm("Rajess", "Singh", uniqueEmail, "9999999999", "Ascendion@123");
        Thread.sleep(3000);  // Delay to observe form data

        log.info("Submitting form");
        regPage.submitForm();
        Thread.sleep(3000);  // Delay to observe result

        log.info("Validating confirmation message");
        String actualMessage = regPage.getConfirmationMessage();
        Assert.assertEquals(actualMessage.trim(), "Your Account Has Been Created!", "Account creation confirmation failed.");
    }
}
