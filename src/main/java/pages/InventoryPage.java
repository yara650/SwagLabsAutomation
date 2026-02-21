/*package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    By pageTitle = By.className("title");
    By cartIcon = By.id("shopping_cart_container");
    By products = By.className("inventory_item");

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public boolean isCartIconDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    public int getProductsCount() {
        return driver.findElements(products).size();
    }
}

 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    By pageTitle = By.className("title");
    By cartIcon = By.id("shopping_cart_container");
    By products = By.className("inventory_item");

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public boolean isCartIconDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    public int getProductCount() {
        List<WebElement> productList = driver.findElements(products);
        return productList.size();
    }
}
