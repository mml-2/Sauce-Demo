package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

import static testframework.core.BaseWebTest.driver;

public class AtlassianNavigationMenu {

    private final By projectLocator = By.xpath("//*[@id=\"ak-jira-navigation\"]/header/nav/div/div[2]/div/button");

   public void selectProjectFromTheNavigationMenu() {
       WebElement projectDropdown = driver().findElement(projectLocator);
       projectDropdown.click();
       List<WebElement> menuItems = projectDropdown.findElements(By.name("BTSL"));
       menuItems.get(0).click();
   }
}
