package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateStoryPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CreateStoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String CreateJiraStory() {
        WebElement createButton = driver.findElement(By.id("create_link"));
        createButton.click();

        WebElement projectDropdown = driver.findElement(By.id("project-field"));
        projectDropdown.clear();
        projectDropdown.sendKeys("BTSL");

        WebElement issueTypeDropdown = driver.findElement(By.id("issuetype-field"));
        issueTypeDropdown.clear();
        issueTypeDropdown.sendKeys("Story");

        WebElement summaryField = driver.findElement(By.id("summary"));
        summaryField.sendKeys("Automated story creation using Selenium");

        WebElement descriptionField = driver.findElement(By.id("description"));
        descriptionField.sendKeys("This story is created as a part of an automation test using Selenium.");

        WebElement createIssueSubmitButton = driver.findElement(By.id("create-issue-submit"));
        createIssueSubmitButton.click();

        WebElement storyKeyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".issue-created-key a")));
        String storyKey = storyKeyElement.getText();
        System.out.println("Story created with key: " + storyKey);

        return storyKey;
    }
}
