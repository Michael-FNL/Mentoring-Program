package baseTest;

import org.junit.jupiter.api.AfterEach;
import org.testng.annotations.AfterMethod;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeMethod;
import util.Config;
import util.DriverCreator;
import util.LoggingUtil;

public class BaseTest {
    private static final String BASE_URL = Config.getProperties("host");

    @BeforeMethod
    @BeforeEach
    public void initDriver() {
        DriverCreator.getDriver().navigate().to(BASE_URL);
        LoggingUtil.log("WebDriver initialized and navigate to: " + BASE_URL);
    }

    @AfterMethod(alwaysRun = true)
    @AfterEach
    public void quitDriver() {
        DriverCreator.quitBrowser();
        LoggingUtil.log("Thread resources closed");
    }
}
