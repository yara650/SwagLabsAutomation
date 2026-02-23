package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartTest extends BaseTest {

    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Test
    public void verifyLinkedInLink() {

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.clickLinkedInIcon();
        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> d.getCurrentUrl().contains("linkedin"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("linkedin"));
    }
    @Test
    public void verifyFacebookLink() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.clickFacebookIcon();
        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> d.getCurrentUrl().contains("facebook"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("facebook"));
    }
    @Test
    public void verifyTwitterLink() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.clickTwitterIcon();
        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> d.getCurrentUrl().contains("x.com"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("x.com"));
    }
    @Test
    public void verifyCartIsEmpty() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.clickCartIcon();
        Assert.assertTrue(inventoryPage.isCartEmpty());
    }
    @Test
    public void addThreeProductsAndVerifyInCart() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        inventoryPage.addProductToCart("Sauce Labs Onesie");
        inventoryPage.clickCartIcon();
        Assert.assertTrue(inventoryPage.isProductInCart("Sauce Labs Backpack"));
        Assert.assertTrue(inventoryPage.isProductInCart("Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(inventoryPage.isProductInCart("Sauce Labs Onesie"));
    }
    @Test
    public void removeOneProductAndVerify() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        inventoryPage.addProductToCart("Sauce Labs Onesie");
        inventoryPage.clickCartIcon();
        inventoryPage.removeProductFromCart("Sauce Labs Bolt T-Shirt");
        driver.navigate().back();
        Assert.assertTrue(inventoryPage.isAddToCartButtonVisible("Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(inventoryPage.isRemoveButtonVisible("Sauce Labs Backpack"));
        Assert.assertTrue(inventoryPage.isRemoveButtonVisible("Sauce Labs Onesie"));
    }
}