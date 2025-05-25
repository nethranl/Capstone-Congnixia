package tests1;

import base.basetest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages1.loginpage;
import pages1.searchpage;

public class searchtest extends basetest {

    @Test
    public void SearchTest() {
        // Step 1: Login to the application
        loginpage login = new loginpage(driver);
        login.login("Admin", "admin123");
        log.info("Logged in as Admin");

        // Step 2: Navigate to Add Job Title page
        searchpage sp = new searchpage(driver);
        sp.clickAdminTab();
        sp.clickJobDropdown();
        sp.clickJobTitles();
        log.info("Navigated to Job Titles page");

        // Step 3: Add new Job Title
        String jobTitle = "Gen Ai n devops Engineer";
        String jobDescription = "AI specialist role";
        String notes = "The future is AI-powered DevOps";

        sp.clickAddButton();
        sp.enterJobTitle(jobTitle);
        sp.enterJobDescription(jobDescription);
        sp.enterNotes(notes);
        sp.clickSaveButton();
        log.info("Job Title added with details");

        // Step 4: Verify redirection to Job Title list page
        Assert.assertTrue(sp.isRedirectedToJobTitleList(), "Failed to redirect to Job Title list after save.");
        log.info("Redirection to Job Title List page validated");

        // Step 5: Logout from the application
        sp.openUserDropdown();
        sp.clickLogout();
        log.info("Logged out successfully after job title creation.");
    }
}
