package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class WebDriverUtil {
    public static WebDriver webDriver;

    public WebDriverUtil(){}
    public static WebDriver getWebDriver() {
        //System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver");
        getBrowserDriverLocation();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        //options.addArguments("--headless");
        options.addArguments("Zoom 50%");
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--enable-javascript");
        //Enable JS
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.javascript", 0);
        options.setExperimentalOption("prefs", prefs);
        //Incognito
        options.addArguments("--incognito");

        webDriver = new ChromeDriver(options);

        return webDriver;
    }

    private static void getBrowserDriverLocation()
    {
        String operatingSystem = System.getProperty("os.name");
        if(operatingSystem.contains("windows"))
        {
            System.setProperty("webdriver.chrome.driver", "browserDrivers/win/chromedriver");
        }
        else if(operatingSystem.contains("mac"))
        {
            System.setProperty("webdriver.chrome.driver", "browserDrivers/mac/chromedriver");
        }
        else if(operatingSystem.contains("linux"))
        {
            System.setProperty("webdriver.chrome.driver", "browserDrivers/linx/chromedriver");
        }
    }
}
