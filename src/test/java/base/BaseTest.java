package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

    public class BaseTest {

        protected WebDriver driver;

        @BeforeMethod
        public void setUp() {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

