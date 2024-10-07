package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LinkBugAndStory {
    private WebDriver driver;
    private WebDriverWait wait;

    public LinkBugAndStory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void linkIssue(String bugKey, String storyKey) {
        // Navigate to the Bug's issue page
        driver.get("" + bugKey);

        WebElement moreButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("opsbar-operations_more")));
        moreButton.click();

        WebElement linkButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-issue")));
        linkButton.click();

        WebElement linkTypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("link-type")));
        linkTypeField.clear();
        linkTypeField.sendKeys("is blocked by");  // Select the "is blocked by" link type

        WebElement issueKeyField = driver.findElement(By.id("issuelink-issues-textarea"));
        issueKeyField.sendKeys(storyKey);

        WebElement linkIssueSubmitButton = driver.findElement(By.id("issue-link-submit"));
        linkIssueSubmitButton.click();

        System.out.println("Bug " + bugKey + " linked to Story " + storyKey + " with 'is blocked by'.");
    }
}