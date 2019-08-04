package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.Driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class WaitsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
    }

    @Test
    public void test1(){

        String locator = "#checkbox>input";
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(locator))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(locator))));
        wait.until((ExpectedConditions.elementToBeClickable(By.cssSelector(locator))));
        driver.findElement(By.cssSelector(locator)).click();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
