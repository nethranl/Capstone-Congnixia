package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class searchpage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By adminTab = By.xpath("//a[contains(@href, 'admin/viewAdminModule')]");
    private By jobDropdown = By.xpath("//span[@class='oxd-topbar-body-nav-tab-item' and contains(text(), 'Job')]");
    private By jobTitlesLink = By.xpath("//a[@class='oxd-topbar-body-nav-tab-link' and text()='Job Titles']");
    private By addButton = By.xpath("//button[contains(@class,'oxd-button oxd-button--medium')]");
    private By jobTitleInput = By.xpath("(//label[text()='Job Title']/following::input)[1]");
    private By jobDescriptionTextarea = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea");
    private By notesTextarea = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/textarea");
    private By saveButton = By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[2]");

    // New locators for user dropdown and logout
    private By userDropdown = By.className("oxd-userdropdown-name");
    private By logoutLink = By.xpath("(//a[@class='oxd-userdropdown-link'])[4]");

    // Locator to validate after save (job title header)
    private By jobTitleHeader = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[1]/h6");

    public searchpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 sec timeout
    }

    public void clickAdminTab() {
        wait.until(ExpectedConditions.elementToBeClickable(adminTab)).click();
        // Small delay just to ensure UI is ready for next step (optional)
        sleep(1000);
    }

    public void clickJobDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(jobDropdown)).click();
        sleep(1000);
    }

    public void clickJobTitles() {
        wait.until(ExpectedConditions.elementToBeClickable(jobTitlesLink)).click();
        sleep(1000);
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
        sleep(1000);
    }

    public void enterJobTitle(String jobTitle) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleInput));
        input.clear();
        input.sendKeys(jobTitle);
        sleep(1000);
    }

    public void enterJobDescription(String description) {
        WebElement descInput = wait.until(ExpectedConditions.visibilityOfElementLocated(jobDescriptionTextarea));
        descInput.clear();
        descInput.sendKeys(description);
        sleep(1000);
    }

    public void enterNotes(String notes) {
        WebElement notesInput = wait.until(ExpectedConditions.visibilityOfElementLocated(notesTextarea));
        notesInput.clear();
        notesInput.sendKeys(notes);
        sleep(1000);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        // No fixed sleep here because wait for redirect handles it
    }

    public void openUserDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
        sleep(1000);
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
        sleep(1000);
    }

    // Wait for redirect URL after clicking save button (up to 15 seconds)
    public boolean isRedirectedToJobTitleList() {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.urlContains("/admin/viewJobTitleList"));
        } catch (Exception e) {
            return false;
        }
    }

    // Optional: check job title header visibility after redirect (fallback)
    public boolean isJobTitleHeaderDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Private helper for small delay
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
