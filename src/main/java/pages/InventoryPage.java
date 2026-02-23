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


    By linkedinIcon = By.cssSelector("a[href*='linkedin']");
    By facebookIcon = By.cssSelector("a[href*='facebook']");
    By twitterIcon = By.cssSelector("a[href*='twitter']");


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

    public void clickLinkedInIcon() {
        driver.findElement(linkedinIcon).click();
    }

    public void clickFacebookIcon() {
        driver.findElement(facebookIcon).click();
    }

    public void clickTwitterIcon() {
        driver.findElement(twitterIcon).click();
    }
    By cartItems = By.className("cart_item");
    public boolean isCartEmpty() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size() == 0;
    }
    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }
    public void addProductToCart(String productName) {
        List<WebElement> allProducts = driver.findElements(products);
        for (WebElement product : allProducts) {
            String name = product.findElement(By.className("inventory_item_name")).getText();
            if (name.equals(productName)) {
                product.findElement(By.tagName("button")).click();
                break;
            }
        }
    }
    public boolean isProductInCart(String productName) {
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        for (WebElement item : cartItems) {
            String name = item.findElement(By.className("inventory_item_name")).getText();
            if (name.equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void removeProductFromCart(String productName) {
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        for (WebElement item : cartItems) {
            String name = item.findElement(By.className("inventory_item_name")).getText();
            if (name.equals(productName)) {
                item.findElement(By.tagName("button")).click();
                break;
            }
        }
    }
    public boolean isAddToCartButtonVisible(String productName) {
        List<WebElement> allProducts = driver.findElements(products);
        for (WebElement product : allProducts) {
            String name = product.findElement(By.className("inventory_item_name")).getText();
            if (name.equals(productName)) {
                String btnText = product.findElement(By.tagName("button")).getText();
                return btnText.equalsIgnoreCase("Add to cart");
            }
        }
        return false;
    }
    public boolean isRemoveButtonVisible(String productName) {
        List<WebElement> allProducts = driver.findElements(products);
        for (WebElement product : allProducts) {
            String name = product.findElement(By.className("inventory_item_name")).getText();
            if (name.equals(productName)) {
                String btnText = product.findElement(By.tagName("button")).getText();
                return btnText.equalsIgnoreCase("Remove");
            }
        }
        return false;
    }
}