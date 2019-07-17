package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BrowserFactory {
    /**
     * @param browser name
     * @return browser object, otherwise throw exception to prevent test run
     */
    public static WebDriver getDriver(String browser) {
        // it's not main method
        // it's a method that returns object of webdriver
        // it can be firefox of chrome based on value of parameter
        // again, we create method to reuse a code

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Wrong browser name!");
        }
    }
}

