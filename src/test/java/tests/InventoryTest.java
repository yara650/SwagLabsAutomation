
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import org.json.simple.JSONObject;
import utils.DataDriven;

public class InventoryTest extends BaseTest {

    @Test
    public void verifyInventoryPageElements() {
        JSONObject data = DataDriven.jsonReader("testData/testData.json");

        JSONObject validCreds = (JSONObject) data.get("validCredentials");
        String username = (String) validCreds.get("username");
        String password = (String) validCreds.get("password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        InventoryPage inventoryPage = new InventoryPage(driver);


        Assert.assertEquals(inventoryPage.getPageTitle(), "Products");
        Assert.assertTrue(inventoryPage.isCartIconDisplayed());
        Assert.assertEquals(inventoryPage.getProductCount(), 6);
    }
}