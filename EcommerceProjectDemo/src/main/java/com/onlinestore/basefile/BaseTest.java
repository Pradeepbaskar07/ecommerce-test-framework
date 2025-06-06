package com.onlinestore.basefile;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.onlinestore.config.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    private String browser;
    private String url;
    private int implicitWait;

    // Load configuration from config.properties
    private void loadConfigurations() {
        browser = ConfigReader.getProperty("browser");
        url = ConfigReader.getProperty("url");
        implicitWait = Integer.parseInt(ConfigReader.getProperty("implicit_wait"));
    }

    // Setup browser based on config
    private void initializeBrowser() {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser in config: " + browser);
        }
    }

    // Configure WebDriver (timeouts, window size, etc.)
    private void configureDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    @BeforeMethod
    public void setup() {
        loadConfigurations();   // Step 1: Load from config.properties
        initializeBrowser();    // Step 2: Launch browser
        configureDriver();      // Step 3: Apply timeouts and open URL
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println(" Unable to quit driver: " + e.getMessage());
            }
        }
    }
}

