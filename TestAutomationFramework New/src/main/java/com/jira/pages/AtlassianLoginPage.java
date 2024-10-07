package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AtlassianLoginPage extends BaseJiraPage{
    public AtlassianLoginPage(String pageSpecificUrl) {
        super("/login");
    }

    //Locators
    //UsernameField - testID
    //submitButton - testID
    //PasswordField - testID

    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By continueButtonLocator = By.xpath("//*[@id=\"login-submit\"]/span");
    private final By loginButtonLocator = By.id("login-submit");

    // Actions
    public void submitLoginForm(String username, String pass) {
        WebElement usernameInput = driver().findElement(usernameLocator);
        usernameInput.sendKeys(username);

        WebElement continueButton = driver().findElement(continueButtonLocator);
        continueButton.click();

        WebElement password = driver().findElement(passwordLocator);
        password.sendKeys(pass);

        WebElement loginButton = driver().findElement(loginButtonLocator);
        loginButton.click();

    }

}
