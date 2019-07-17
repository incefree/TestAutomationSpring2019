package day11_vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SeleniumUtils;
import utilities.VYTrackUtils;

import java.util.concurrent.TimeUnit;
// test NG does not care abot the position of the method
public class CreateButtonTests {

    WebDriver driver;
    String createButtonLocator = "a[title='Log call']"; // locator for log call button
    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";

    @BeforeMethod
    public void setup(){
        //driver setup
        WebDriverManager.chromedriver().setup();
        //to initialize driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
    }

    @Test (priority = 1)
    public void storeManagerTest(){
        //login
        VYTrackUtils.login(driver, "storemanager85", "UserUser123");
        //navigate to the Calls
        VYTrackUtils.navigateToModule(driver, "Activities", "Calls");
        //assert true that button "log call" is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());
        SeleniumUtils.waitPlease(1);
        //navigate to the Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        //Verify that Create Calendar Event is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());
    }

    @Test (priority = 2)
    public void salesManagerTest(){
        //login
        VYTrackUtils.login(driver, "salesmanager253", "UserUser123");
        //navigate to the Calls
        VYTrackUtils.navigateToModule(driver, "Activities", "Calls");
        //assert true that button "log call" is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());
        SeleniumUtils.waitPlease(1);
        //navigate to the Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        //Verify that Create Calendar Event is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}