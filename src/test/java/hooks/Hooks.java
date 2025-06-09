package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import util.Config;
import util.DriverCreator;
import util.LoggingUtil;

public class Hooks {
    private static final String BASE_URL = Config.getProperties("host");

    @Before
    public void initDriver() {
        DriverCreator.getDriver().navigate().to(BASE_URL);
        LoggingUtil.log("WebDriver initialized and navigate to: " + BASE_URL);
    }

    @After
    public void quitDriver() {
        DriverCreator.quitBrowser();
        LoggingUtil.log("Thread resources closed");
    }
}
