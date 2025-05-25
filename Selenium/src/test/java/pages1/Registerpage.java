package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registerpage {
    WebDriver driver;

    public Registerpage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By registerLink = By.xpath("//*[@id='column-right']/div/a[2]");
    By firstNameInput = By.xpath("//*[@id='input-firstname']");
    By lastNameInput = By.xpath("//*[@id='input-lastname']");
    By emailInput = By.xpath("//*[@id='input-email']");
    By telephoneInput = By.xpath("//*[@id='input-telephone']");
    By passwordInput = By.xpath("//*[@id='input-password']");
    By confirmPasswordInput = By.xpath("//*[@id='input-confirm']");
    By subscribeNoRadio = By.xpath("(//label[@class='custom-control-label'])[2]");
    By privacyPolicyCheckbox = By.xpath("(//label[@class='custom-control-label'])[3]");
    By continueButton = By.xpath("//*[@id='content']/form/div/div/input");
    By confirmationMessage = By.xpath("//*[@id='content']/h1");

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void fillForm(String firstName, String lastName, String email, String telephone, String password) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(telephoneInput).sendKeys(telephone);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(password);
        driver.findElement(subscribeNoRadio).click();
        driver.findElement(privacyPolicyCheckbox).click();
    }

    public void submitForm() {
        driver.findElement(continueButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}
