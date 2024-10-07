package saucedemotests.web;

import com.saucedemo.api.models.Product;
import com.saucedemo.pages.CheckoutCompletePage;
import com.saucedemo.pages.CheckoutOverviewPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import saucedemotests.core.SauceDemoBaseWebTest;
import saucedemotests.enums.TestData;

import java.time.Duration;
import java.util.List;

import static testframework.DriverManager.driver;

public class ProductsTests extends SauceDemoBaseWebTest {
    public final String BACKPACK_TITLE = "Sauce Labs Backpack";
    public final String SHIRT_TITLE = "Sauce Labs Bolt T-Shirt";

    @BeforeEach
    public void beforeTest(){
        loginPage.navigate();
        authenticateWithUser("standard_user", "secret_sauce");
    }
        // Authenticate with Standard user

    @Test
    public void productAddedToShoppingCart_when_addToCart() throws InterruptedException {
        // Add products to shopping cart
        inventoryPage.addProductsByTitle(BACKPACK_TITLE);
        inventoryPage.addProductsByTitle(SHIRT_TITLE);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        var items = driver.findElements(By.className("inventory_item_name"));

        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        Assertions.assertEquals(BACKPACK_TITLE, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(SHIRT_TITLE, items.get(1).getText(), "Item title not as expected");
    }
        // Go to shopping cart

        // Assert Items and Totals

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() throws InterruptedException{
        // Add products to shopping cart
        WebElement checkoutButton=driver.findElement(By.xpath("//button[contains(@class, 'checkout_button')]"));
        checkoutButton.click();

        Thread.sleep(1000);

        WebElement firstNameField=driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("test");

        WebElement lastNameField=driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("test");

        WebElement postalCodeField=driver.findElement(By.id("postal-code"));
        postalCodeField.sendKeys("0001");

        WebElement continueButton=driver.findElement(By.className("btn_primary cart_button"));
        continueButton.click();

        // Go to shopping cart

        // Go to checkout

        // Fill form

        // Continue

        // Assert Cart Items number

        // Calculate expected total cost

        // Assert Cart Items Titles and total cost
        }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm(){
        inventoryPage.addProductsByTitle(BACKPACK_TITLE);
        inventoryPage.addProductsByTitle(SHIRT_TITLE);

        Assertions.assertEquals(2, inventoryPage.getShoppingCartItemsNumber(), "shopping cart Items were not added.");

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        driver.findElement(By.id("checkout")).click();

        // fill form
        checkoutYourInformationPage.fillShippingDetails("Fname", "lname", "zip");

        checkoutYourInformationPage.clickContinue();

        checkoutOverviewPage.clickFinish();

        Assertions.assertEquals(0, inventoryPage.getShoppingCartItemsNumber(), "shopping cart was not emptied after purchase.");
    }
        
        // Assert Items removed from Shopping Cart

        // Complete Order

        // Assert Shopping cart is empty
    }