package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static testframework.DriverManager.driver;

public class AtlassianHomePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement h1Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
}
