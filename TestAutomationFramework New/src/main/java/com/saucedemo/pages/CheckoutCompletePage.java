package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BaseSauceDemoPage {
    public CheckoutCompletePage() {
        super("/checkout-complete.html");

        By orderCompletedMessage = By.xpath("//h2[@class='complete-header']");
        By backToProductsButton = By.id("back-to-products");
    }
}
