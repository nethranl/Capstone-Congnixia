package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginpage {
    WebDriver driver;
    WebDriverWait wait;

    public loginpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Login locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.tagName("button");

    // Admin navigation locators
    private By adminTab = By.xpath("//a[contains(@href, 'admin/viewAdminModule')]");
    private By userManagement = By.xpath("//span[text()='User Management ']");
    private By usersOption = By.xpath("//ul[@class='oxd-dropdown-menu']//li[1]");
    private By addButton = By.xpath("//button[text()=' Add ']");

    // Form field locators
    private By userRoleDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private By employeeNameInput = By.xpath("(//label[text()='Employee Name']/following::input)[1]");
    private By statusDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    private By usernameInput = By.xpath("(//label[text()='Username']/following::input)[1]");
    private By passwordInput = By.xpath("(//input[@type='password'])[1]");
    private By confirmPasswordInput = By.xpath("(//input[@type='password'])[2]");
    private By saveButton = By.xpath("//button[@type='submit']");

    // Logout locators
    private By userDropdown = By.className("oxd-userdropdown-name");
    private By logoutLink = By.xpath("(//a[@class='oxd-userdropdown-link'])[4]");

    // Login action
    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        delay(2000);
    }

    // Navigate to user management
    public void goToUserManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(adminTab)).click();
        delay(1000);
        wait.until(ExpectedConditions.elementToBeClickable(userManagement)).click();
        delay(1000);
        wait.until(ExpectedConditions.elementToBeClickable(usersOption)).click();
        delay(2000);
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        delay(2000);
    }

    public void selectUserRoleAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown)).click();
        delay(1000);

        By dropdownOptions = By.xpath("//div[@role='listbox']//div[@class='oxd-select-option']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownOptions));

        By adminOption = By.xpath("//div[@role='listbox']//span[text()='Admin']");
        wait.until(ExpectedConditions.elementToBeClickable(adminOption)).click();
        delay(1000);
    }

    public void enterEmployeeName(String empName) {
        // Type employee name
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameInput));
        input.sendKeys(empName);
        delay(2000);

        // Use Actions to press Down and Enter to select the first dropdown suggestion
        Actions actions = new Actions(driver);
        actions.moveToElement(input).click().sendKeys(org.openqa.selenium.Keys.ARROW_DOWN).sendKeys(org.openqa.selenium.Keys.ENTER).build().perform();
        delay(1000);
    }

    public void selectStatusEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();
        delay(1000);

        By dropdownOptions = By.xpath("//div[@role='listbox']//div[@class='oxd-select-option']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownOptions));

        By enabledOption = By.xpath("//div[@role='listbox']//span[text()='Enabled']");
        wait.until(ExpectedConditions.elementToBeClickable(enabledOption)).click();
        delay(1000);
    }

    public void enterUsername(String username) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        input.sendKeys(username);
        delay(1000);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordInput)).sendKeys(password);
        delay(1000);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        delay(3000);
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
        delay(1500);
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
        delay(2000);
    }

    private void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
