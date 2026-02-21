
package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.json.simple.JSONObject;
import utils.DataDriven;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void verifySuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Read valid credentials from JSON
        JSONObject data = DataDriven.jsonReader("testData/testData.json");
        JSONObject validCreds = (JSONObject) data.get("validCredentials");

        String username = (String) validCreds.get("username");
        String password = (String) validCreds.get("password");

        loginPage.login(username, password);

        // Wait until redirected to inventory page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/inventory.html"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"));
    }

    @Test
    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Read invalid credentials from JSON
        JSONObject data = DataDriven.jsonReader("testData/testData.json");
        JSONObject invalidCreds = (JSONObject) data.get("invalidCredentials");

        String username = (String) invalidCreds.get("username");
        String password = (String) invalidCreds.get("password");

        loginPage.login(username, password);

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match"));
    }

    @Test
    public void verifyLoginWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);

        // Read valid username but leave password empty
        JSONObject data = DataDriven.jsonReader("testData/testData.json");
        JSONObject validCreds = (JSONObject) data.get("validCredentials");

        String username = (String) validCreds.get("username");

        loginPage.login(username, "");

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Password is required"));
    }
}
