package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static testframework.DriverManager.driver;

public class CreateIssuePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CreateIssuePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String createJiraIssue() {

        WebElement createButton = driver.findElement(By.id("create_link"));
        createButton.click();
        WebElement projectDropdown = driver.findElement(By.id("project-field"));
        projectDropdown.click();
        projectDropdown.clear();
        projectDropdown.sendKeys("BTSL");

        WebElement issueTypeDropdown = driver.findElement(By.id("issue-field-select-base.ui.format-option-label.c-label\">Epic"));
        issueTypeDropdown.clear();
        issueTypeDropdown.sendKeys("Bug");

        WebElement summaryField = driver.findElement(By.id("summary"));
        summaryField.sendKeys("Automated issue summary");

        WebElement descriptionField = driver.findElement(By.id("description"));
        descriptionField.sendKeys("This is a test issue created using Selenium.");

        WebElement createIssueSubmitButton = driver.findElement(By.id("issue-create.common.ui.footer.create-button"));
        createIssueSubmitButton.click();

        WebElement bugKeyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".issue-created-key a")));
        String bugKey = bugKeyElement.getText();
        System.out.println("Bug created with key: " + bugKey);

        return bugKey;
    }
}
