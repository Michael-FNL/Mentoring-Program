package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverCreator {
    public static final int TIMEOUT = 30;
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> WAIT = new ThreadLocal<>();

    private DriverCreator() {

    }

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
            initializeDriver();
        }
        return DRIVER.get();
    }

    private static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (Boolean.parseBoolean(Config.getProperties("headlessMode"))) {
            options.addArguments("--headless");
        }

        DRIVER.set(new ChromeDriver(options));
        WebDriver webDriver = DRIVER.get();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        WAIT.set(new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT)));
    }

    public static WebDriverWait getWait() {
        return WAIT.get();
    }

    public static void quitBrowser() {
        WebDriver webDriver = DRIVER.get();
        if (webDriver != null) {
            webDriver.quit();
            DRIVER.remove();
            WAIT.remove();
        }
    }
}
