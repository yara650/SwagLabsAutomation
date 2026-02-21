
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to perform login
    public void login(String username, String password) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);

        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);

        driver.findElement(loginButton).click();
    }

    // **Add this method to return the error message**
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
